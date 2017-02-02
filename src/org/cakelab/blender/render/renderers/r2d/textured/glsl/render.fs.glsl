#version 420 core

// Texture object received from application.
// Textures are directly sent to the fragment shader and don't 
// take the detour via the vertex shader like other inputs.
layout (binding = 0) uniform sampler2D tex_object;
// base color from material
uniform vec4 basecolor;

// input from vertex shader
in VS_OUT
{
	// Texture coordinate corresponding to the fragments location
	// received from vertex and tesselation shaders.
    vec2 tc;
} fs_in;


// Output to framebuffer
out vec4 color;

void main(void)
{
	vec4 texcolor;
	// Simply read from the texture at the coordinates, and
	// assign the result to the shader's output.
    texcolor = texture(tex_object, fs_in.tc);
    
    // override base color with texture color based on its alpha value.
//    color = texcolor*(texcolor.a) + basecolor*(1.0-texcolor.a);
    color = texcolor * vec4(basecolor.rgb,1);
//    color.w = 1;
}
