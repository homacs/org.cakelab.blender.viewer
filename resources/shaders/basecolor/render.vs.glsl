#version 420 core

uniform mat4 mv_matrix;
uniform mat4 proj_matrix;
// base color from material
uniform vec4 basecolor;

//
// Two vertex attributes received from application
//

// Vertex position (vertex attribut 0).
layout (location = 0) in vec4 position;

out VS_OUT
{
    // base color from material to be applied in fragment shader
    vec4 basecolor;
} vs_out;

void main(void)
{
	vs_out.basecolor = basecolor;
    gl_Position = proj_matrix * mv_matrix * position; 
}
