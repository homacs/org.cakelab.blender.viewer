#version 420 core

uniform mat4 mv_matrix;
uniform mat4 proj_matrix;

//
// Two vertex attributes received from application
//

// Vertex position (vertex attribut 0).
layout (location = 0) in vec4 position;
// Texture coordinate (vertex attribute 4) 
// corresponding to the given vertex position.
layout (location = 4) in vec2 tc;

out VS_OUT
{
	// texture coordinate to be forwarded to subsequent 
	// render stages. Remember that the tesselation stage will
	// eventually insert additional vertices and corresponding
	// texture coordinates will be interpolated based on the 
	// information given here. 
    vec2 tc;
} vs_out;

void main(void)
{
    vs_out.tc = tc;

    gl_Position = proj_matrix * mv_matrix * position; 
}
