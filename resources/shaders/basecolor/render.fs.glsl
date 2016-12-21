#version 420 core

// input from vertex shader
in VS_OUT
{
    // base color from material
    vec4 basecolor;
} fs_in;


// Output to framebuffer
out vec4 color;

void main(void)
{
    // override base color with texture color based on its alpha value.
    color = fs_in.basecolor; 
}
