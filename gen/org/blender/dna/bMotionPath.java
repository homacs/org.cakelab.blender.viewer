package org.blender.dna;

import java.io.IOException;
import org.cakelab.blender.io.block.Block;
import org.cakelab.blender.io.block.BlockTable;
import org.cakelab.blender.nio.CFacade;
import org.cakelab.blender.nio.CMetaData;
import org.cakelab.blender.nio.CPointer;


/**
 * Generated facet for DNA struct type 'bMotionPath'.
 * 
 * <h3>Class Documentation</h3>
 * <h4>Blender Source Code:</h4>
 * <p> ........ Motion {@link Path}  data cache (mpath)<ul><li><p> for elements providing transforms (i.e. Objects or PoseChannels) </p></li></ul> 
 * for elements providing transforms (i.e. Objects or PoseChannels) 
 * </p>
 */

@CMetaData(size32=20, size64=24)
public class bMotionPath extends CFacade {

	/**
	 * This is the sdna index of the struct bMotionPath.
	 * <p>
	 * It is required when allocating a new block to store data for bMotionPath.
	 * </p>
	 * @see {@link org.cakelab.blender.io.dna.internal.StructDNA}
	 * @see {@link org.cakelab.blender.io.block.BlockTable#allocate}
	 */
	public static final int __DNA__SDNA_INDEX = 341;

	/**
	 * Field descriptor (offset) for struct member 'points'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> path samples </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * bMotionPath bmotionpath = ...;
	 * CPointer&lt;Object&gt; p = bmotionpath.__dna__addressof(bMotionPath.__DNA__FIELD__points);
	 * CPointer&lt;CPointer&lt;bMotionPathVert&gt;&gt; p_points = p.cast(new Class[]{CPointer.class, bMotionPathVert.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'points'</li>
	 * <li>Signature: 'bMotionPathVert*'</li>
	 * <li>Actual Size (32bit/64bit): 4/8</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__points = new long[]{0, 0};

	/**
	 * Field descriptor (offset) for struct member 'length'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> the number of cached verts </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * bMotionPath bmotionpath = ...;
	 * CPointer&lt;Object&gt; p = bmotionpath.__dna__addressof(bMotionPath.__DNA__FIELD__length);
	 * CPointer&lt;Integer&gt; p_length = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'length'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__length = new long[]{4, 8};

	/**
	 * Field descriptor (offset) for struct member 'start_frame'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> for drawing paths, the start frame number </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * bMotionPath bmotionpath = ...;
	 * CPointer&lt;Object&gt; p = bmotionpath.__dna__addressof(bMotionPath.__DNA__FIELD__start_frame);
	 * CPointer&lt;Integer&gt; p_start_frame = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'start_frame'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__start_frame = new long[]{8, 12};

	/**
	 * Field descriptor (offset) for struct member 'end_frame'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> for drawing paths, the end frame number </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * bMotionPath bmotionpath = ...;
	 * CPointer&lt;Object&gt; p = bmotionpath.__dna__addressof(bMotionPath.__DNA__FIELD__end_frame);
	 * CPointer&lt;Integer&gt; p_end_frame = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'end_frame'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__end_frame = new long[]{12, 16};

	/**
	 * Field descriptor (offset) for struct member 'flag'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> baking settings - eMotionPath_Flag </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * bMotionPath bmotionpath = ...;
	 * CPointer&lt;Object&gt; p = bmotionpath.__dna__addressof(bMotionPath.__DNA__FIELD__flag);
	 * CPointer&lt;Integer&gt; p_flag = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'flag'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__flag = new long[]{16, 20};

	public bMotionPath(long __address, Block __block, BlockTable __blockTable) {
		super(__address, __block, __blockTable);
	}

	protected bMotionPath(bMotionPath that) {
		super(that.__io__address, that.__io__block, that.__io__blockTable);
	}

	/**
	 * Get method for struct member 'points'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> path samples </p>
	 * @see #__DNA__FIELD__points
	 */
	
	public CPointer<bMotionPathVert> getPoints() throws IOException
	{
		long __dna__targetAddress;
		if ((__io__pointersize == 8)) {
			__dna__targetAddress = __io__block.readLong(__io__address + 0);
		} else {
			__dna__targetAddress = __io__block.readLong(__io__address + 0);
		}
		Class<?>[] __dna__targetTypes = new Class[]{bMotionPathVert.class};
		return new CPointer<bMotionPathVert>(__dna__targetAddress, __dna__targetTypes, __io__blockTable.getBlock(__dna__targetAddress, bMotionPathVert.__DNA__SDNA_INDEX), __io__blockTable);
	}

	/**
	 * Set method for struct member 'points'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> path samples </p>
	 * @see #__DNA__FIELD__points
	 */
	
	public void setPoints(CPointer<bMotionPathVert> points) throws IOException
	{
		long __address = ((points == null) ? 0 : points.getAddress());
		if ((__io__pointersize == 8)) {
			__io__block.writeLong(__io__address + 0, __address);
		} else {
			__io__block.writeLong(__io__address + 0, __address);
		}
	}

	/**
	 * Get method for struct member 'length'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> the number of cached verts </p>
	 * @see #__DNA__FIELD__length
	 */
	
	public int getLength() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8);
		} else {
			return __io__block.readInt(__io__address + 4);
		}
	}

	/**
	 * Set method for struct member 'length'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> the number of cached verts </p>
	 * @see #__DNA__FIELD__length
	 */
	
	public void setLength(int length) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8, length);
		} else {
			__io__block.writeInt(__io__address + 4, length);
		}
	}

	/**
	 * Get method for struct member 'start_frame'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> for drawing paths, the start frame number </p>
	 * @see #__DNA__FIELD__start_frame
	 */
	
	public int getStart_frame() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 12);
		} else {
			return __io__block.readInt(__io__address + 8);
		}
	}

	/**
	 * Set method for struct member 'start_frame'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> for drawing paths, the start frame number </p>
	 * @see #__DNA__FIELD__start_frame
	 */
	
	public void setStart_frame(int start_frame) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 12, start_frame);
		} else {
			__io__block.writeInt(__io__address + 8, start_frame);
		}
	}

	/**
	 * Get method for struct member 'end_frame'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> for drawing paths, the end frame number </p>
	 * @see #__DNA__FIELD__end_frame
	 */
	
	public int getEnd_frame() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 16);
		} else {
			return __io__block.readInt(__io__address + 12);
		}
	}

	/**
	 * Set method for struct member 'end_frame'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> for drawing paths, the end frame number </p>
	 * @see #__DNA__FIELD__end_frame
	 */
	
	public void setEnd_frame(int end_frame) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 16, end_frame);
		} else {
			__io__block.writeInt(__io__address + 12, end_frame);
		}
	}

	/**
	 * Get method for struct member 'flag'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> baking settings - eMotionPath_Flag </p>
	 * @see #__DNA__FIELD__flag
	 */
	
	public int getFlag() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 20);
		} else {
			return __io__block.readInt(__io__address + 16);
		}
	}

	/**
	 * Set method for struct member 'flag'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> baking settings - eMotionPath_Flag </p>
	 * @see #__DNA__FIELD__flag
	 */
	
	public void setFlag(int flag) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 20, flag);
		} else {
			__io__block.writeInt(__io__address + 16, flag);
		}
	}

	/**
	 * Instantiates a pointer on this instance.
	 */
	public CPointer<bMotionPath> __io__addressof() {
		return new CPointer<bMotionPath>(__io__address, new Class[]{bMotionPath.class}, __io__block, __io__blockTable);
	}

}