#version 410 core


out VS_OUT
{
	vec4 color;
} vs_out;


uniform mat4 mv_matrix;
uniform mat4 proj_matrix;

void main(void)
{
	vec4 position = vec4(0.0, 0.0, 0.0, 1.0);
	int i = gl_VertexID/2;
	position[i] = gl_VertexID - (i*2);
	gl_Position = proj_matrix * mv_matrix * position;
	vec4 color  = vec4(0.0, 0.0, 0.0, 1.0);
	color[i]  = 1.0;
	vs_out.color = color;
}