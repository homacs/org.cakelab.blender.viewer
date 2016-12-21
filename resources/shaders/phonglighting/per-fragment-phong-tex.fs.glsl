#version 420 core


// Texture object received from application.
// Textures are directly sent to the fragment shader and don't 
// take the detour via the vertex shader like other inputs.
layout (binding = 0) uniform sampler2D tex_object;


// Output
layout (location = 0) out vec4 color;

// Input from vertex shader
in VS_OUT
{
    vec3 N;
    vec3 L;
    vec3 V;
    vec2 tc;
} fs_in;

// Material properties
uniform vec3 diffuse_color = vec3(0.5, 0.2, 0.7);
uniform vec3 specular_color = vec3(0.7);
uniform float specular_power = 128.0;
uniform vec3 ambient_color = vec3(0.1, 0.1, 0.1);

void main(void)
{
	//
	// fetch texture color and mix with diffuse
	//
	
	vec4 texcolor;
	// Simply read from the texture at the coordinates, and
	// assign the result to the shader's output.
    texcolor = texture(tex_object, fs_in.tc);
    
    // diffuse color with texture color based on its alpha value.
    vec3 diffuse = (texcolor.rgb*(texcolor.a) + diffuse_color*(1.0-texcolor.a)).rgb; 



	//
	// do phong shading
	//	

    // Normalize the incoming N, L and V vectors
    vec3 N = normalize(fs_in.N);
    vec3 L = normalize(fs_in.L);
    vec3 V = normalize(fs_in.V);

    // Calculate R locally
    vec3 R = reflect(-L, N);

    // Compute the diffuse and specular components for each fragment
    diffuse = max(dot(N, L), 0.0) * diffuse;
    vec3 specular = pow(max(dot(R, V), 0.0), specular_power) * specular_color;

    // Write final color to the framebuffer
    color = vec4(ambient_color + diffuse + specular, 1.0);
}
