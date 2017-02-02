package org.cakelab.blender.render.debug.normals;

import static org.lwjgl.opengl.GL20.*;

import java.io.IOException;

import org.cakelab.blender.render.data.BRObjectRenderData;
import org.cakelab.oge.app.ApplicationContext;
import org.cakelab.oge.module.Module;
import org.cakelab.oge.scene.VisualMeshEntity;
import org.cakelab.oge.scene.VisualEntity;
import org.cakelab.oge.shader.FragmentShader;
import org.cakelab.oge.shader.GLException;
import org.cakelab.oge.shader.GeometryShader;
import org.cakelab.oge.shader.Program;
import org.cakelab.oge.shader.VertexShader;
import org.cakelab.oge.utils.SingleProgramRendererBase;



public class NormalRenderer extends SingleProgramRendererBase {
	private int uniform_normal_length;
	private float normal_length = 0.2f;
	private int module;

	public NormalRenderer(Module mod) throws GLException, IOException {
		this.module = mod.getModuleId();
		loadShaders();
		
	}


	private void loadShaders() throws GLException, IOException {
		// TODO move shaders in files
		VertexShader vs = new VertexShader("normal viewer vertex shader", 
				"#version 410 core                                                  \n" +
	            "                                                                   \n" +
	            "layout (location = 0) in vec3 position;                            \n" +
	            "layout (location = 1) in vec3 normal;                              \n" +
	            "                                                                   \n" +
	            "out VS_OUT                                                         \n" +
	            "{                                                                  \n" +
	            "    vec3 normal;                                                   \n" +
	            "    vec4 color;                                                    \n" +
	            "} vs_out;                                                          \n" +
	            "                                                                   \n" +
	            "void main(void)                                                    \n" +
	            "{                                                                  \n" +
	            "    gl_Position = vec4(position,1);                                        \n" +
	            "    vs_out.color = gl_Position * 2.0 + vec4(0.5, 0.5, 0.5, 0.0);      \n" +
	            "    vs_out.normal = normalize(normal);                             \n" +
	            "}                                                                  \n"
		);
		GeometryShader gs = new GeometryShader("normal viewer geometryy shader",
	            "#version 410 core                                                      \n" +
                "                                                                       \n" +
                "layout (triangles) in;                                                 \n" +
                "layout (line_strip, max_vertices = 4) out;                             \n" +
                "                                                                       \n" +
                "uniform mat4 mv_matrix;                                                \n" +
                "uniform mat4 proj_matrix;                                              \n" +
                "                                                                       \n" +
                "in VS_OUT                                                              \n" +
                "{                                                                      \n" +
                "    vec3 normal;                                                       \n" +
                "    vec4 color;                                                        \n" +
                "} gs_in[];                                                             \n" +
                "                                                                       \n" +
                "out GS_OUT                                                             \n" +
                "{                                                                      \n" +
                "    vec3 normal;                                                       \n" +
                "    vec4 color;                                                        \n" +
                "} gs_out;                                                              \n" +
                "                                                                       \n" +
                "uniform float normal_length = 0.2;                                     \n" +
                "                                                                       \n" +
                "void main(void)                                                        \n" +
                "{                                                                      \n" +
                "    mat4 mvp = proj_matrix * mv_matrix;                                \n" +
                "    vec3 ab = gl_in[1].gl_Position.xyz - gl_in[0].gl_Position.xyz;     \n" +
                "    vec3 ac = gl_in[2].gl_Position.xyz - gl_in[0].gl_Position.xyz;     \n" +
                "    vec3 face_normal = normalize(cross(ab, ac));                      \n" +
                "                                                                       \n" +
                "    vec4 tri_centroid = (gl_in[0].gl_Position +                        \n" +
                "                         gl_in[1].gl_Position +                        \n" +
                "                         gl_in[2].gl_Position) / 3.0;                  \n" +
                "                                                                       \n" +
                "    gl_Position = mvp * tri_centroid;                                  \n" +
                "    gs_out.normal = gs_in[0].normal;                                   \n" +
                "    gs_out.color = gs_in[0].color;                                     \n" +
                "    EmitVertex();                                                      \n" +
                "                                                                       \n" +
                "    gl_Position = mvp * (tri_centroid +                                \n" +
                "                         vec4(face_normal * normal_length, 0.0));      \n" +
                "    gs_out.normal = gs_in[0].normal;                                   \n" +
                "    gs_out.color = gs_in[0].color;                                     \n" +
                "    EmitVertex();                                                      \n" +
                "    EndPrimitive();                                                    \n" +
                "                                                                       \n" +
                "    gl_Position = mvp * gl_in[0].gl_Position;                          \n" +
                "    gs_out.normal = gs_in[0].normal;                                   \n" +
                "    gs_out.color = gs_in[0].color;                                     \n" +
                "    EmitVertex();                                                      \n" +
                "                                                                       \n" +
                "    gl_Position = mvp * (gl_in[0].gl_Position +                        \n" +
                "                         vec4(gs_in[0].normal * normal_length, 0.0));  \n" +
                "    gs_out.normal = gs_in[0].normal;                                   \n" +
                "    gs_out.color = gs_in[0].color;                                     \n" +
                "    EmitVertex();                                                      \n" +
                "    EndPrimitive();                                                    \n" +
                "}                                                                      \n"
		);
		FragmentShader fs = new FragmentShader("normal viewer fragment shader", 
	            "#version 410 core                                                  \n" +
                "                                                                   \n" +
                "out vec4 color;                                                    \n" +
                "                                                                   \n" +
                "in GS_OUT                                                          \n" +
                "{                                                                  \n" +
                "    vec3 normal;                                                   \n" +
                "    vec4 color;                                                    \n" +
                "} fs_in;                                                           \n" +
                "                                                                   \n" +
                "void main(void)                                                    \n" +
                "{                                                                  \n" +
                "    color = vec4(1.0) * abs(normalize(fs_in.normal).z);            \n" +
                "}                                                                  \n"
		);

		setShaderProgram(new Program("basecolor shader program", vs, gs, fs));
		
		vs.delete();
		fs.delete();
		
		uniform_normal_length = shaderProgram.getUniformLocation("normal_length");
	}

	public void delete() {
	}

	
	@Override
	public void prepareRenderPass(ApplicationContext context, double currentTime) {
		glUniform1f(uniform_normal_length, normal_length );
	}

	@Override
	public void draw(double currentTime, VisualEntity vo) {
		VisualMeshEntity o = (VisualMeshEntity) vo;
		BRObjectRenderData assets = (BRObjectRenderData) o.getModuleData(module);
		assets.bind();
		assets.draw();
	}


	@Override
	public boolean needsNormals() {
		return true;
	}


	@Override
	public boolean needsUv() {
		return false;
	}

}
