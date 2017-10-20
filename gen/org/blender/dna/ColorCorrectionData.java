package org.blender.dna;

import java.io.IOException;
import org.cakelab.blender.io.block.Block;
import org.cakelab.blender.io.block.BlockTable;
import org.cakelab.blender.nio.CFacade;
import org.cakelab.blender.nio.CMetaData;
import org.cakelab.blender.nio.CPointer;


/**
 * Generated facet for DNA struct type 'ColorCorrectionData'.
 * 
 * <h3>Class Documentation</h3>
 * 
 */

@CMetaData(size32=24, size64=24)
public class ColorCorrectionData extends CFacade {

	/**
	 * This is the sdna index of the struct ColorCorrectionData.
	 * <p>
	 * It is required when allocating a new block to store data for ColorCorrectionData.
	 * </p>
	 * @see {@link org.cakelab.blender.io.dna.internal.StructDNA}
	 * @see {@link org.cakelab.blender.io.block.BlockTable#allocate}
	 */
	public static final int __DNA__SDNA_INDEX = 406;

	/**
	 * Field descriptor (offset) for struct member 'saturation'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * ColorCorrectionData colorcorrectiondata = ...;
	 * CPointer&lt;Object&gt; p = colorcorrectiondata.__dna__addressof(ColorCorrectionData.__DNA__FIELD__saturation);
	 * CPointer&lt;Float&gt; p_saturation = p.cast(new Class[]{Float.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'saturation'</li>
	 * <li>Signature: 'float'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__saturation = new long[]{0, 0};

	/**
	 * Field descriptor (offset) for struct member 'contrast'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * ColorCorrectionData colorcorrectiondata = ...;
	 * CPointer&lt;Object&gt; p = colorcorrectiondata.__dna__addressof(ColorCorrectionData.__DNA__FIELD__contrast);
	 * CPointer&lt;Float&gt; p_contrast = p.cast(new Class[]{Float.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'contrast'</li>
	 * <li>Signature: 'float'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__contrast = new long[]{4, 4};

	/**
	 * Field descriptor (offset) for struct member 'gamma'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * ColorCorrectionData colorcorrectiondata = ...;
	 * CPointer&lt;Object&gt; p = colorcorrectiondata.__dna__addressof(ColorCorrectionData.__DNA__FIELD__gamma);
	 * CPointer&lt;Float&gt; p_gamma = p.cast(new Class[]{Float.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'gamma'</li>
	 * <li>Signature: 'float'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__gamma = new long[]{8, 8};

	/**
	 * Field descriptor (offset) for struct member 'gain'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * ColorCorrectionData colorcorrectiondata = ...;
	 * CPointer&lt;Object&gt; p = colorcorrectiondata.__dna__addressof(ColorCorrectionData.__DNA__FIELD__gain);
	 * CPointer&lt;Float&gt; p_gain = p.cast(new Class[]{Float.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'gain'</li>
	 * <li>Signature: 'float'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__gain = new long[]{12, 12};

	/**
	 * Field descriptor (offset) for struct member 'lift'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * ColorCorrectionData colorcorrectiondata = ...;
	 * CPointer&lt;Object&gt; p = colorcorrectiondata.__dna__addressof(ColorCorrectionData.__DNA__FIELD__lift);
	 * CPointer&lt;Float&gt; p_lift = p.cast(new Class[]{Float.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'lift'</li>
	 * <li>Signature: 'float'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__lift = new long[]{16, 16};

	/**
	 * Field descriptor (offset) for struct member 'pad'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * ColorCorrectionData colorcorrectiondata = ...;
	 * CPointer&lt;Object&gt; p = colorcorrectiondata.__dna__addressof(ColorCorrectionData.__DNA__FIELD__pad);
	 * CPointer&lt;Integer&gt; p_pad = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'pad'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__pad = new long[]{20, 20};

	public ColorCorrectionData(long __address, Block __block, BlockTable __blockTable) {
		super(__address, __block, __blockTable);
	}

	protected ColorCorrectionData(ColorCorrectionData that) {
		super(that.__io__address, that.__io__block, that.__io__blockTable);
	}

	/**
	 * Get method for struct member 'saturation'.
	 * @see #__DNA__FIELD__saturation
	 */
	
	public float getSaturation() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readFloat(__io__address + 0);
		} else {
			return __io__block.readFloat(__io__address + 0);
		}
	}

	/**
	 * Set method for struct member 'saturation'.
	 * @see #__DNA__FIELD__saturation
	 */
	
	public void setSaturation(float saturation) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeFloat(__io__address + 0, saturation);
		} else {
			__io__block.writeFloat(__io__address + 0, saturation);
		}
	}

	/**
	 * Get method for struct member 'contrast'.
	 * @see #__DNA__FIELD__contrast
	 */
	
	public float getContrast() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readFloat(__io__address + 4);
		} else {
			return __io__block.readFloat(__io__address + 4);
		}
	}

	/**
	 * Set method for struct member 'contrast'.
	 * @see #__DNA__FIELD__contrast
	 */
	
	public void setContrast(float contrast) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeFloat(__io__address + 4, contrast);
		} else {
			__io__block.writeFloat(__io__address + 4, contrast);
		}
	}

	/**
	 * Get method for struct member 'gamma'.
	 * @see #__DNA__FIELD__gamma
	 */
	
	public float getGamma() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readFloat(__io__address + 8);
		} else {
			return __io__block.readFloat(__io__address + 8);
		}
	}

	/**
	 * Set method for struct member 'gamma'.
	 * @see #__DNA__FIELD__gamma
	 */
	
	public void setGamma(float gamma) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeFloat(__io__address + 8, gamma);
		} else {
			__io__block.writeFloat(__io__address + 8, gamma);
		}
	}

	/**
	 * Get method for struct member 'gain'.
	 * @see #__DNA__FIELD__gain
	 */
	
	public float getGain() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readFloat(__io__address + 12);
		} else {
			return __io__block.readFloat(__io__address + 12);
		}
	}

	/**
	 * Set method for struct member 'gain'.
	 * @see #__DNA__FIELD__gain
	 */
	
	public void setGain(float gain) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeFloat(__io__address + 12, gain);
		} else {
			__io__block.writeFloat(__io__address + 12, gain);
		}
	}

	/**
	 * Get method for struct member 'lift'.
	 * @see #__DNA__FIELD__lift
	 */
	
	public float getLift() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readFloat(__io__address + 16);
		} else {
			return __io__block.readFloat(__io__address + 16);
		}
	}

	/**
	 * Set method for struct member 'lift'.
	 * @see #__DNA__FIELD__lift
	 */
	
	public void setLift(float lift) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeFloat(__io__address + 16, lift);
		} else {
			__io__block.writeFloat(__io__address + 16, lift);
		}
	}

	/**
	 * Get method for struct member 'pad'.
	 * @see #__DNA__FIELD__pad
	 */
	
	public int getPad() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 20);
		} else {
			return __io__block.readInt(__io__address + 20);
		}
	}

	/**
	 * Set method for struct member 'pad'.
	 * @see #__DNA__FIELD__pad
	 */
	
	public void setPad(int pad) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 20, pad);
		} else {
			__io__block.writeInt(__io__address + 20, pad);
		}
	}

	/**
	 * Instantiates a pointer on this instance.
	 */
	public CPointer<ColorCorrectionData> __io__addressof() {
		return new CPointer<ColorCorrectionData>(__io__address, new Class[]{ColorCorrectionData.class}, __io__block, __io__blockTable);
	}

}
