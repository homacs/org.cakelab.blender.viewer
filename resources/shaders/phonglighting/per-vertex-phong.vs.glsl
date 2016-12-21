#version 410 core

// Per-vertex inputs
layout (location = 0) in vec3 position;
layout (location = 1) in vec3 normal;

uniform mat4 mv_matrix;
uniform mat4 proj_matrix;
// uniform mat4 view_matrix;

// Light and material properties
uniform vec3 light_pos;
uniform vec3 diffuse_color = vec3(0.5, 0.2, 0.7);
uniform vec3 specular_color = vec3(0.7);
uniform float specular_power = 128.0;
uniform vec3 ambient_color = vec3(0.1, 0.1, 0.1);

// Outputs to the fragment shader
out VS_OUT
{
    vec3 color;
} vs_out;

void main(void)
{

    // Calculate view-space coordinate
    vec4 P = mv_matrix * vec4(position,1);

	vec3 light_position = light_pos;

    // Calculate normal in view space
    vec3 N = mat3(mv_matrix) * normal;
    // Calculate view-space light vector
    vec3 L = light_position - P.xyz;
    // Calculate view vector (simply the negative of the view-space position)
    vec3 V = -P.xyz;

    // Normalize all three vectors
    N = normalize(N);
    L = normalize(L);
    V = normalize(V);
    // Calculate R by reflecting -L around the plane defined by N
    vec3 R = reflect(-L, N);

    // Calculate the diffuse and specular contributions
    vec3 diffuse = max(dot(N, L), 0.0) * (diffuse_color);
    vec3 specular = pow(max(dot(R, V), 0.0), specular_power) * specular_color;

    // Send the color output to the fragment shader
    vs_out.color = ambient_color + diffuse + specular;

    // Calculate the clip-space position of each vertex
    gl_Position = proj_matrix * P;
}
