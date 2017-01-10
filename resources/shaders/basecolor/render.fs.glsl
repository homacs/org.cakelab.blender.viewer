#version 420 core


// base color from material
uniform vec4 basecolor;


// Output to framebuffer
out vec4 color;

void main(void)
{
	// just copy given color to output
    color = basecolor; 
}
