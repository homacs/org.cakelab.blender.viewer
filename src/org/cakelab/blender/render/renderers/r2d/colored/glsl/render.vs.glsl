#version 420 core

uniform mat4 mv_matrix;
uniform mat4 proj_matrix;

// Vertex position (vertex attribut 0).
layout (location = 0) in vec4 position;

void main(void)
{
    gl_Position = proj_matrix * mv_matrix * position; 
//    gl_Position = proj_matrix * position; 
}
