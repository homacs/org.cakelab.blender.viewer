#version 420 core

uniform mat4 mv_matrix;
uniform mat4 proj_matrix;

//
// Vertex attributes received from application
//

// Vertex position (vertex attribut 0).
// Note: OpenGl adds the 4th component if we feed just vec3
layout (location = 0) in vec4 position;

void main(void)
{
    gl_Position = proj_matrix * mv_matrix * position; 
}
