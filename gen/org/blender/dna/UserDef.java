package org.blender.dna;

import java.io.IOException;
import org.cakelab.blender.io.block.Block;
import org.cakelab.blender.io.block.BlockTable;
import org.cakelab.blender.nio.CArrayFacade;
import org.cakelab.blender.nio.CFacade;
import org.cakelab.blender.nio.CMetaData;
import org.cakelab.blender.nio.CPointer;


/**
 * Generated facet for DNA struct type 'UserDef'.
 * 
 * <h3>Class Documentation</h3>
 * 
 */

@CMetaData(size32=11952, size64=12008)
public class UserDef extends CFacade {

	/**
	 * This is the sdna index of the struct UserDef.
	 * <p>
	 * It is required when allocating a new block to store data for UserDef.
	 * </p>
	 * @see {@link org.cakelab.blender.io.dna.internal.StructDNA}
	 * @see {@link org.cakelab.blender.io.block.BlockTable#allocate}
	 */
	public static final int __DNA__SDNA_INDEX = 250;

	/**
	 * Field descriptor (offset) for struct member 'versionfile'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p>{@link UserDef}  has separate do-version handling, and can be read from other files </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__versionfile);
	 * CPointer&lt;Integer&gt; p_versionfile = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'versionfile'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__versionfile = new long[]{0, 0};

	/**
	 * Field descriptor (offset) for struct member 'subversionfile'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__subversionfile);
	 * CPointer&lt;Integer&gt; p_subversionfile = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'subversionfile'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__subversionfile = new long[]{4, 4};

	/**
	 * Field descriptor (offset) for struct member 'flag'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__flag);
	 * CPointer&lt;Integer&gt; p_flag = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'flag'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__flag = new long[]{8, 8};

	/**
	 * Field descriptor (offset) for struct member 'dupflag'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__dupflag);
	 * CPointer&lt;Integer&gt; p_dupflag = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'dupflag'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__dupflag = new long[]{12, 12};

	/**
	 * Field descriptor (offset) for struct member 'savetime'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__savetime);
	 * CPointer&lt;Integer&gt; p_savetime = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'savetime'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__savetime = new long[]{16, 16};

	/**
	 * Field descriptor (offset) for struct member 'tempdir'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> FILE_MAXDIR length </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__tempdir);
	 * CPointer&lt;CArrayFacade&lt;Byte&gt;&gt; p_tempdir = p.cast(new Class[]{CArrayFacade.class, Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'tempdir'</li>
	 * <li>Signature: 'char[768]'</li>
	 * <li>Actual Size (32bit/64bit): 768/768</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__tempdir = new long[]{20, 20};

	/**
	 * Field descriptor (offset) for struct member 'fontdir'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__fontdir);
	 * CPointer&lt;CArrayFacade&lt;Byte&gt;&gt; p_fontdir = p.cast(new Class[]{CArrayFacade.class, Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'fontdir'</li>
	 * <li>Signature: 'char[768]'</li>
	 * <li>Actual Size (32bit/64bit): 768/768</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__fontdir = new long[]{788, 788};

	/**
	 * Field descriptor (offset) for struct member 'renderdir'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> FILE_MAX length </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__renderdir);
	 * CPointer&lt;CArrayFacade&lt;Byte&gt;&gt; p_renderdir = p.cast(new Class[]{CArrayFacade.class, Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'renderdir'</li>
	 * <li>Signature: 'char[1024]'</li>
	 * <li>Actual Size (32bit/64bit): 1024/1024</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__renderdir = new long[]{1556, 1556};

	/**
	 * Field descriptor (offset) for struct member 'render_cachedir'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> EXR cache path 768 = FILE_MAXDIR </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__render_cachedir);
	 * CPointer&lt;CArrayFacade&lt;Byte&gt;&gt; p_render_cachedir = p.cast(new Class[]{CArrayFacade.class, Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'render_cachedir'</li>
	 * <li>Signature: 'char[768]'</li>
	 * <li>Actual Size (32bit/64bit): 768/768</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__render_cachedir = new long[]{2580, 2580};

	/**
	 * Field descriptor (offset) for struct member 'textudir'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__textudir);
	 * CPointer&lt;CArrayFacade&lt;Byte&gt;&gt; p_textudir = p.cast(new Class[]{CArrayFacade.class, Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'textudir'</li>
	 * <li>Signature: 'char[768]'</li>
	 * <li>Actual Size (32bit/64bit): 768/768</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__textudir = new long[]{3348, 3348};

	/**
	 * Field descriptor (offset) for struct member 'pythondir'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__pythondir);
	 * CPointer&lt;CArrayFacade&lt;Byte&gt;&gt; p_pythondir = p.cast(new Class[]{CArrayFacade.class, Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'pythondir'</li>
	 * <li>Signature: 'char[768]'</li>
	 * <li>Actual Size (32bit/64bit): 768/768</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__pythondir = new long[]{4116, 4116};

	/**
	 * Field descriptor (offset) for struct member 'sounddir'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__sounddir);
	 * CPointer&lt;CArrayFacade&lt;Byte&gt;&gt; p_sounddir = p.cast(new Class[]{CArrayFacade.class, Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'sounddir'</li>
	 * <li>Signature: 'char[768]'</li>
	 * <li>Actual Size (32bit/64bit): 768/768</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__sounddir = new long[]{4884, 4884};

	/**
	 * Field descriptor (offset) for struct member 'i18ndir'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__i18ndir);
	 * CPointer&lt;CArrayFacade&lt;Byte&gt;&gt; p_i18ndir = p.cast(new Class[]{CArrayFacade.class, Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'i18ndir'</li>
	 * <li>Signature: 'char[768]'</li>
	 * <li>Actual Size (32bit/64bit): 768/768</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__i18ndir = new long[]{5652, 5652};

	/**
	 * Field descriptor (offset) for struct member 'image_editor'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> 1024 = FILE_MAX </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__image_editor);
	 * CPointer&lt;CArrayFacade&lt;Byte&gt;&gt; p_image_editor = p.cast(new Class[]{CArrayFacade.class, Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'image_editor'</li>
	 * <li>Signature: 'char[1024]'</li>
	 * <li>Actual Size (32bit/64bit): 1024/1024</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__image_editor = new long[]{6420, 6420};

	/**
	 * Field descriptor (offset) for struct member 'anim_player'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> 1024 = FILE_MAX </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__anim_player);
	 * CPointer&lt;CArrayFacade&lt;Byte&gt;&gt; p_anim_player = p.cast(new Class[]{CArrayFacade.class, Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'anim_player'</li>
	 * <li>Signature: 'char[1024]'</li>
	 * <li>Actual Size (32bit/64bit): 1024/1024</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__anim_player = new long[]{7444, 7444};

	/**
	 * Field descriptor (offset) for struct member 'anim_player_preset'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__anim_player_preset);
	 * CPointer&lt;Integer&gt; p_anim_player_preset = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'anim_player_preset'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__anim_player_preset = new long[]{8468, 8468};

	/**
	 * Field descriptor (offset) for struct member 'v2d_min_gridsize'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> minimum spacing between gridlines in {@link View2D}  grids </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__v2d_min_gridsize);
	 * CPointer&lt;Short&gt; p_v2d_min_gridsize = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'v2d_min_gridsize'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__v2d_min_gridsize = new long[]{8472, 8472};

	/**
	 * Field descriptor (offset) for struct member 'timecode_style'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> style of timecode display </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__timecode_style);
	 * CPointer&lt;Short&gt; p_timecode_style = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'timecode_style'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__timecode_style = new long[]{8474, 8474};

	/**
	 * Field descriptor (offset) for struct member 'versions'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__versions);
	 * CPointer&lt;Short&gt; p_versions = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'versions'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__versions = new long[]{8476, 8476};

	/**
	 * Field descriptor (offset) for struct member 'dbl_click_time'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__dbl_click_time);
	 * CPointer&lt;Short&gt; p_dbl_click_time = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'dbl_click_time'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__dbl_click_time = new long[]{8478, 8478};

	/**
	 * Field descriptor (offset) for struct member 'gameflags'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__gameflags);
	 * CPointer&lt;Short&gt; p_gameflags = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'gameflags'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__gameflags = new long[]{8480, 8480};

	/**
	 * Field descriptor (offset) for struct member 'wheellinescroll'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__wheellinescroll);
	 * CPointer&lt;Short&gt; p_wheellinescroll = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'wheellinescroll'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__wheellinescroll = new long[]{8482, 8482};

	/**
	 * Field descriptor (offset) for struct member 'uiflag'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__uiflag);
	 * CPointer&lt;Integer&gt; p_uiflag = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'uiflag'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__uiflag = new long[]{8484, 8484};

	/**
	 * Field descriptor (offset) for struct member 'uiflag2'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__uiflag2);
	 * CPointer&lt;Integer&gt; p_uiflag2 = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'uiflag2'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__uiflag2 = new long[]{8488, 8488};

	/**
	 * Field descriptor (offset) for struct member 'language'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__language);
	 * CPointer&lt;Integer&gt; p_language = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'language'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__language = new long[]{8492, 8492};

	/**
	 * Field descriptor (offset) for struct member 'userpref'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__userpref);
	 * CPointer&lt;Short&gt; p_userpref = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'userpref'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__userpref = new long[]{8496, 8496};

	/**
	 * Field descriptor (offset) for struct member 'viewzoom'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__viewzoom);
	 * CPointer&lt;Short&gt; p_viewzoom = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'viewzoom'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__viewzoom = new long[]{8498, 8498};

	/**
	 * Field descriptor (offset) for struct member 'mixbufsize'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__mixbufsize);
	 * CPointer&lt;Integer&gt; p_mixbufsize = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'mixbufsize'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__mixbufsize = new long[]{8500, 8500};

	/**
	 * Field descriptor (offset) for struct member 'audiodevice'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__audiodevice);
	 * CPointer&lt;Integer&gt; p_audiodevice = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'audiodevice'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__audiodevice = new long[]{8504, 8504};

	/**
	 * Field descriptor (offset) for struct member 'audiorate'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__audiorate);
	 * CPointer&lt;Integer&gt; p_audiorate = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'audiorate'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__audiorate = new long[]{8508, 8508};

	/**
	 * Field descriptor (offset) for struct member 'audioformat'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__audioformat);
	 * CPointer&lt;Integer&gt; p_audioformat = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'audioformat'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__audioformat = new long[]{8512, 8512};

	/**
	 * Field descriptor (offset) for struct member 'audiochannels'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__audiochannels);
	 * CPointer&lt;Integer&gt; p_audiochannels = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'audiochannels'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__audiochannels = new long[]{8516, 8516};

	/**
	 * Field descriptor (offset) for struct member 'scrollback'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> console scrollback limit </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__scrollback);
	 * CPointer&lt;Integer&gt; p_scrollback = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'scrollback'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__scrollback = new long[]{8520, 8520};

	/**
	 * Field descriptor (offset) for struct member 'dpi'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> range 48-128? </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__dpi);
	 * CPointer&lt;Integer&gt; p_dpi = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'dpi'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__dpi = new long[]{8524, 8524};

	/**
	 * Field descriptor (offset) for struct member 'node_margin'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> node insert offset (aka auto-offset) margin, but might be useful for later stuff as well </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__node_margin);
	 * CPointer&lt;Byte&gt; p_node_margin = p.cast(new Class[]{Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'node_margin'</li>
	 * <li>Signature: 'char'</li>
	 * <li>Actual Size (32bit/64bit): 1/1</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__node_margin = new long[]{8528, 8528};

	/**
	 * Field descriptor (offset) for struct member 'pad2'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__pad2);
	 * CPointer&lt;Byte&gt; p_pad2 = p.cast(new Class[]{Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'pad2'</li>
	 * <li>Signature: 'char'</li>
	 * <li>Actual Size (32bit/64bit): 1/1</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__pad2 = new long[]{8529, 8529};

	/**
	 * Field descriptor (offset) for struct member 'transopts'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__transopts);
	 * CPointer&lt;Short&gt; p_transopts = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'transopts'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__transopts = new long[]{8530, 8530};

	/**
	 * Field descriptor (offset) for struct member 'menuthreshold1'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__menuthreshold1);
	 * CPointer&lt;Short&gt; p_menuthreshold1 = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'menuthreshold1'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__menuthreshold1 = new long[]{8532, 8532};

	/**
	 * Field descriptor (offset) for struct member 'menuthreshold2'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__menuthreshold2);
	 * CPointer&lt;Short&gt; p_menuthreshold2 = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'menuthreshold2'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__menuthreshold2 = new long[]{8534, 8534};

	/**
	 * Field descriptor (offset) for struct member 'themes'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__themes);
	 * CPointer&lt;ListBase&gt; p_themes = p.cast(new Class[]{ListBase.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'themes'</li>
	 * <li>Signature: 'ListBase'</li>
	 * <li>Actual Size (32bit/64bit): 8/16</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__themes = new long[]{8536, 8536};

	/**
	 * Field descriptor (offset) for struct member 'uifonts'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__uifonts);
	 * CPointer&lt;ListBase&gt; p_uifonts = p.cast(new Class[]{ListBase.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'uifonts'</li>
	 * <li>Signature: 'ListBase'</li>
	 * <li>Actual Size (32bit/64bit): 8/16</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__uifonts = new long[]{8544, 8552};

	/**
	 * Field descriptor (offset) for struct member 'uistyles'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__uistyles);
	 * CPointer&lt;ListBase&gt; p_uistyles = p.cast(new Class[]{ListBase.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'uistyles'</li>
	 * <li>Signature: 'ListBase'</li>
	 * <li>Actual Size (32bit/64bit): 8/16</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__uistyles = new long[]{8552, 8568};

	/**
	 * Field descriptor (offset) for struct member 'keymaps'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p><p> deprecated in favor of user_keymaps </p>
	 * @deprecated
	 *  Deprecateddeprecated in favor of user_keymaps </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__keymaps);
	 * CPointer&lt;ListBase&gt; p_keymaps = p.cast(new Class[]{ListBase.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'keymaps'</li>
	 * <li>Signature: 'ListBase'</li>
	 * <li>Actual Size (32bit/64bit): 8/16</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__keymaps = new long[]{8560, 8584};

	/**
	 * Field descriptor (offset) for struct member 'user_keymaps'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__user_keymaps);
	 * CPointer&lt;ListBase&gt; p_user_keymaps = p.cast(new Class[]{ListBase.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'user_keymaps'</li>
	 * <li>Signature: 'ListBase'</li>
	 * <li>Actual Size (32bit/64bit): 8/16</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__user_keymaps = new long[]{8568, 8600};

	/**
	 * Field descriptor (offset) for struct member 'addons'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__addons);
	 * CPointer&lt;ListBase&gt; p_addons = p.cast(new Class[]{ListBase.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'addons'</li>
	 * <li>Signature: 'ListBase'</li>
	 * <li>Actual Size (32bit/64bit): 8/16</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__addons = new long[]{8576, 8616};

	/**
	 * Field descriptor (offset) for struct member 'autoexec_paths'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__autoexec_paths);
	 * CPointer&lt;ListBase&gt; p_autoexec_paths = p.cast(new Class[]{ListBase.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'autoexec_paths'</li>
	 * <li>Signature: 'ListBase'</li>
	 * <li>Actual Size (32bit/64bit): 8/16</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__autoexec_paths = new long[]{8584, 8632};

	/**
	 * Field descriptor (offset) for struct member 'keyconfigstr'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__keyconfigstr);
	 * CPointer&lt;CArrayFacade&lt;Byte&gt;&gt; p_keyconfigstr = p.cast(new Class[]{CArrayFacade.class, Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'keyconfigstr'</li>
	 * <li>Signature: 'char[64]'</li>
	 * <li>Actual Size (32bit/64bit): 64/64</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__keyconfigstr = new long[]{8592, 8648};

	/**
	 * Field descriptor (offset) for struct member 'undosteps'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__undosteps);
	 * CPointer&lt;Short&gt; p_undosteps = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'undosteps'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__undosteps = new long[]{8656, 8712};

	/**
	 * Field descriptor (offset) for struct member 'undomemory'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__undomemory);
	 * CPointer&lt;Short&gt; p_undomemory = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'undomemory'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__undomemory = new long[]{8658, 8714};

	/**
	 * Field descriptor (offset) for struct member 'gp_manhattendist'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__gp_manhattendist);
	 * CPointer&lt;Short&gt; p_gp_manhattendist = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'gp_manhattendist'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__gp_manhattendist = new long[]{8660, 8716};

	/**
	 * Field descriptor (offset) for struct member 'gp_euclideandist'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__gp_euclideandist);
	 * CPointer&lt;Short&gt; p_gp_euclideandist = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'gp_euclideandist'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__gp_euclideandist = new long[]{8662, 8718};

	/**
	 * Field descriptor (offset) for struct member 'gp_eraser'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__gp_eraser);
	 * CPointer&lt;Short&gt; p_gp_eraser = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'gp_eraser'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__gp_eraser = new long[]{8664, 8720};

	/**
	 * Field descriptor (offset) for struct member 'gp_settings'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__gp_settings);
	 * CPointer&lt;Short&gt; p_gp_settings = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'gp_settings'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__gp_settings = new long[]{8666, 8722};

	/**
	 * Field descriptor (offset) for struct member 'tb_leftmouse'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__tb_leftmouse);
	 * CPointer&lt;Short&gt; p_tb_leftmouse = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'tb_leftmouse'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__tb_leftmouse = new long[]{8668, 8724};

	/**
	 * Field descriptor (offset) for struct member 'tb_rightmouse'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__tb_rightmouse);
	 * CPointer&lt;Short&gt; p_tb_rightmouse = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'tb_rightmouse'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__tb_rightmouse = new long[]{8670, 8726};

	/**
	 * Field descriptor (offset) for struct member 'light'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__light);
	 * CPointer&lt;CArrayFacade&lt;SolidLight&gt;&gt; p_light = p.cast(new Class[]{CArrayFacade.class, SolidLight.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'light'</li>
	 * <li>Signature: 'SolidLight[3]'</li>
	 * <li>Actual Size (32bit/64bit): 168/168</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__light = new long[]{8672, 8728};

	/**
	 * Field descriptor (offset) for struct member 'tw_hotspot'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__tw_hotspot);
	 * CPointer&lt;Short&gt; p_tw_hotspot = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'tw_hotspot'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__tw_hotspot = new long[]{8840, 8896};

	/**
	 * Field descriptor (offset) for struct member 'tw_flag'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__tw_flag);
	 * CPointer&lt;Short&gt; p_tw_flag = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'tw_flag'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__tw_flag = new long[]{8842, 8898};

	/**
	 * Field descriptor (offset) for struct member 'tw_handlesize'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__tw_handlesize);
	 * CPointer&lt;Short&gt; p_tw_handlesize = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'tw_handlesize'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__tw_handlesize = new long[]{8844, 8900};

	/**
	 * Field descriptor (offset) for struct member 'tw_size'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__tw_size);
	 * CPointer&lt;Short&gt; p_tw_size = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'tw_size'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__tw_size = new long[]{8846, 8902};

	/**
	 * Field descriptor (offset) for struct member 'textimeout'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__textimeout);
	 * CPointer&lt;Short&gt; p_textimeout = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'textimeout'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__textimeout = new long[]{8848, 8904};

	/**
	 * Field descriptor (offset) for struct member 'texcollectrate'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__texcollectrate);
	 * CPointer&lt;Short&gt; p_texcollectrate = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'texcollectrate'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__texcollectrate = new long[]{8850, 8906};

	/**
	 * Field descriptor (offset) for struct member 'wmdrawmethod'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> removed wmpad </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__wmdrawmethod);
	 * CPointer&lt;Short&gt; p_wmdrawmethod = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'wmdrawmethod'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__wmdrawmethod = new long[]{8852, 8908};

	/**
	 * Field descriptor (offset) for struct member 'dragthreshold'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__dragthreshold);
	 * CPointer&lt;Short&gt; p_dragthreshold = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'dragthreshold'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__dragthreshold = new long[]{8854, 8910};

	/**
	 * Field descriptor (offset) for struct member 'memcachelimit'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__memcachelimit);
	 * CPointer&lt;Integer&gt; p_memcachelimit = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'memcachelimit'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__memcachelimit = new long[]{8856, 8912};

	/**
	 * Field descriptor (offset) for struct member 'prefetchframes'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__prefetchframes);
	 * CPointer&lt;Integer&gt; p_prefetchframes = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'prefetchframes'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__prefetchframes = new long[]{8860, 8916};

	/**
	 * Field descriptor (offset) for struct member 'pad_rot_angle'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> control the rotation step of the view when PAD2, PAD4, PAD6&PAD8 is use </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__pad_rot_angle);
	 * CPointer&lt;Float&gt; p_pad_rot_angle = p.cast(new Class[]{Float.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'pad_rot_angle'</li>
	 * <li>Signature: 'float'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__pad_rot_angle = new long[]{8864, 8920};

	/**
	 * Field descriptor (offset) for struct member 'frameserverport'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__frameserverport);
	 * CPointer&lt;Short&gt; p_frameserverport = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'frameserverport'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__frameserverport = new long[]{8868, 8924};

	/**
	 * Field descriptor (offset) for struct member 'pad4'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__pad4);
	 * CPointer&lt;Short&gt; p_pad4 = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'pad4'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__pad4 = new long[]{8870, 8926};

	/**
	 * Field descriptor (offset) for struct member 'obcenter_dia'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__obcenter_dia);
	 * CPointer&lt;Short&gt; p_obcenter_dia = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'obcenter_dia'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__obcenter_dia = new long[]{8872, 8928};

	/**
	 * Field descriptor (offset) for struct member 'rvisize'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> rotating view icon size </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__rvisize);
	 * CPointer&lt;Short&gt; p_rvisize = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'rvisize'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__rvisize = new long[]{8874, 8930};

	/**
	 * Field descriptor (offset) for struct member 'rvibright'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> rotating view icon brightness </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__rvibright);
	 * CPointer&lt;Short&gt; p_rvibright = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'rvibright'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__rvibright = new long[]{8876, 8932};

	/**
	 * Field descriptor (offset) for struct member 'recent_files'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> maximum number of recently used files to remember </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__recent_files);
	 * CPointer&lt;Short&gt; p_recent_files = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'recent_files'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__recent_files = new long[]{8878, 8934};

	/**
	 * Field descriptor (offset) for struct member 'smooth_viewtx'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> miliseconds to spend spinning the view </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__smooth_viewtx);
	 * CPointer&lt;Short&gt; p_smooth_viewtx = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'smooth_viewtx'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__smooth_viewtx = new long[]{8880, 8936};

	/**
	 * Field descriptor (offset) for struct member 'glreslimit'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__glreslimit);
	 * CPointer&lt;Short&gt; p_glreslimit = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'glreslimit'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__glreslimit = new long[]{8882, 8938};

	/**
	 * Field descriptor (offset) for struct member 'curssize'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__curssize);
	 * CPointer&lt;Short&gt; p_curssize = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'curssize'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__curssize = new long[]{8884, 8940};

	/**
	 * Field descriptor (offset) for struct member 'color_picker_type'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__color_picker_type);
	 * CPointer&lt;Short&gt; p_color_picker_type = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'color_picker_type'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__color_picker_type = new long[]{8886, 8942};

	/**
	 * Field descriptor (offset) for struct member 'ipo_new'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> interpolation mode for newly added F-Curves </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__ipo_new);
	 * CPointer&lt;Byte&gt; p_ipo_new = p.cast(new Class[]{Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'ipo_new'</li>
	 * <li>Signature: 'char'</li>
	 * <li>Actual Size (32bit/64bit): 1/1</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__ipo_new = new long[]{8888, 8944};

	/**
	 * Field descriptor (offset) for struct member 'keyhandles_new'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> handle types for newly added keyframes </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__keyhandles_new);
	 * CPointer&lt;Byte&gt; p_keyhandles_new = p.cast(new Class[]{Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'keyhandles_new'</li>
	 * <li>Signature: 'char'</li>
	 * <li>Actual Size (32bit/64bit): 1/1</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__keyhandles_new = new long[]{8889, 8945};

	/**
	 * Field descriptor (offset) for struct member 'gpu_select_method'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__gpu_select_method);
	 * CPointer&lt;Byte&gt; p_gpu_select_method = p.cast(new Class[]{Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'gpu_select_method'</li>
	 * <li>Signature: 'char'</li>
	 * <li>Actual Size (32bit/64bit): 1/1</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__gpu_select_method = new long[]{8890, 8946};

	/**
	 * Field descriptor (offset) for struct member 'view_frame_type'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__view_frame_type);
	 * CPointer&lt;Byte&gt; p_view_frame_type = p.cast(new Class[]{Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'view_frame_type'</li>
	 * <li>Signature: 'char'</li>
	 * <li>Actual Size (32bit/64bit): 1/1</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__view_frame_type = new long[]{8891, 8947};

	/**
	 * Field descriptor (offset) for struct member 'view_frame_keyframes'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> number of keyframes to zoom around current frame </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__view_frame_keyframes);
	 * CPointer&lt;Integer&gt; p_view_frame_keyframes = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'view_frame_keyframes'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__view_frame_keyframes = new long[]{8892, 8948};

	/**
	 * Field descriptor (offset) for struct member 'view_frame_seconds'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> seconds to zoom around current frame </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__view_frame_seconds);
	 * CPointer&lt;Float&gt; p_view_frame_seconds = p.cast(new Class[]{Float.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'view_frame_seconds'</li>
	 * <li>Signature: 'float'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__view_frame_seconds = new long[]{8896, 8952};

	/**
	 * Field descriptor (offset) for struct member 'scrcastfps'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> frame rate for screencast to be played back </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__scrcastfps);
	 * CPointer&lt;Short&gt; p_scrcastfps = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'scrcastfps'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__scrcastfps = new long[]{8900, 8956};

	/**
	 * Field descriptor (offset) for struct member 'scrcastwait'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> milliseconds between screencast snapshots </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__scrcastwait);
	 * CPointer&lt;Short&gt; p_scrcastwait = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'scrcastwait'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__scrcastwait = new long[]{8902, 8958};

	/**
	 * Field descriptor (offset) for struct member 'widget_unit'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> private, defaults to 20 for 72 DPI setting </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__widget_unit);
	 * CPointer&lt;Short&gt; p_widget_unit = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'widget_unit'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__widget_unit = new long[]{8904, 8960};

	/**
	 * Field descriptor (offset) for struct member 'anisotropic_filter'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__anisotropic_filter);
	 * CPointer&lt;Short&gt; p_anisotropic_filter = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'anisotropic_filter'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__anisotropic_filter = new long[]{8906, 8962};

	/**
	 * Field descriptor (offset) for struct member 'use_16bit_textures'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__use_16bit_textures);
	 * CPointer&lt;Short&gt; p_use_16bit_textures = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'use_16bit_textures'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__use_16bit_textures = new long[]{8908, 8964};

	/**
	 * Field descriptor (offset) for struct member 'use_gpu_mipmap'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__use_gpu_mipmap);
	 * CPointer&lt;Short&gt; p_use_gpu_mipmap = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'use_gpu_mipmap'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__use_gpu_mipmap = new long[]{8910, 8966};

	/**
	 * Field descriptor (offset) for struct member 'ndof_sensitivity'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> overall sensitivity of 3D mouse </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__ndof_sensitivity);
	 * CPointer&lt;Float&gt; p_ndof_sensitivity = p.cast(new Class[]{Float.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'ndof_sensitivity'</li>
	 * <li>Signature: 'float'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__ndof_sensitivity = new long[]{8912, 8968};

	/**
	 * Field descriptor (offset) for struct member 'ndof_orbit_sensitivity'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__ndof_orbit_sensitivity);
	 * CPointer&lt;Float&gt; p_ndof_orbit_sensitivity = p.cast(new Class[]{Float.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'ndof_orbit_sensitivity'</li>
	 * <li>Signature: 'float'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__ndof_orbit_sensitivity = new long[]{8916, 8972};

	/**
	 * Field descriptor (offset) for struct member 'ndof_deadzone'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> deadzone of 3D mouse </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__ndof_deadzone);
	 * CPointer&lt;Float&gt; p_ndof_deadzone = p.cast(new Class[]{Float.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'ndof_deadzone'</li>
	 * <li>Signature: 'float'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__ndof_deadzone = new long[]{8920, 8976};

	/**
	 * Field descriptor (offset) for struct member 'ndof_flag'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> flags for 3D mouse </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__ndof_flag);
	 * CPointer&lt;Integer&gt; p_ndof_flag = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'ndof_flag'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__ndof_flag = new long[]{8924, 8980};

	/**
	 * Field descriptor (offset) for struct member 'ogl_multisamples'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> amount of samples for OpenGL FSA, if zero no FSA </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__ogl_multisamples);
	 * CPointer&lt;Short&gt; p_ogl_multisamples = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'ogl_multisamples'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__ogl_multisamples = new long[]{8928, 8984};

	/**
	 * Field descriptor (offset) for struct member 'image_draw_method'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> Method to be used to draw the images (AUTO, GLSL, Textures or DrawPixels) </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__image_draw_method);
	 * CPointer&lt;Short&gt; p_image_draw_method = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'image_draw_method'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__image_draw_method = new long[]{8930, 8986};

	/**
	 * Field descriptor (offset) for struct member 'glalphaclip'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__glalphaclip);
	 * CPointer&lt;Float&gt; p_glalphaclip = p.cast(new Class[]{Float.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'glalphaclip'</li>
	 * <li>Signature: 'float'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__glalphaclip = new long[]{8932, 8988};

	/**
	 * Field descriptor (offset) for struct member 'autokey_mode'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> autokeying mode </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__autokey_mode);
	 * CPointer&lt;Short&gt; p_autokey_mode = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'autokey_mode'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__autokey_mode = new long[]{8936, 8992};

	/**
	 * Field descriptor (offset) for struct member 'autokey_flag'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> flags for autokeying </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__autokey_flag);
	 * CPointer&lt;Short&gt; p_autokey_flag = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'autokey_flag'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__autokey_flag = new long[]{8938, 8994};

	/**
	 * Field descriptor (offset) for struct member 'text_render'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__text_render);
	 * CPointer&lt;Short&gt; p_text_render = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'text_render'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__text_render = new long[]{8940, 8996};

	/**
	 * Field descriptor (offset) for struct member 'pad9'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> options for text rendering </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__pad9);
	 * CPointer&lt;Short&gt; p_pad9 = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'pad9'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__pad9 = new long[]{8942, 8998};

	/**
	 * Field descriptor (offset) for struct member 'coba_weight'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> from texture.h </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__coba_weight);
	 * CPointer&lt;ColorBand&gt; p_coba_weight = p.cast(new Class[]{ColorBand.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'coba_weight'</li>
	 * <li>Signature: 'ColorBand'</li>
	 * <li>Actual Size (32bit/64bit): 776/776</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__coba_weight = new long[]{8944, 9000};

	/**
	 * Field descriptor (offset) for struct member 'sculpt_paint_overlay_col'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__sculpt_paint_overlay_col);
	 * CPointer&lt;CArrayFacade&lt;Float&gt;&gt; p_sculpt_paint_overlay_col = p.cast(new Class[]{CArrayFacade.class, Float.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'sculpt_paint_overlay_col'</li>
	 * <li>Signature: 'float[3]'</li>
	 * <li>Actual Size (32bit/64bit): 12/12</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__sculpt_paint_overlay_col = new long[]{9720, 9776};

	/**
	 * Field descriptor (offset) for struct member 'gpencil_new_layer_col'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> default color for newly created Grease Pencil layers </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__gpencil_new_layer_col);
	 * CPointer&lt;CArrayFacade&lt;Float&gt;&gt; p_gpencil_new_layer_col = p.cast(new Class[]{CArrayFacade.class, Float.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'gpencil_new_layer_col'</li>
	 * <li>Signature: 'float[4]'</li>
	 * <li>Actual Size (32bit/64bit): 16/16</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__gpencil_new_layer_col = new long[]{9732, 9788};

	/**
	 * Field descriptor (offset) for struct member 'tweak_threshold'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__tweak_threshold);
	 * CPointer&lt;Short&gt; p_tweak_threshold = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'tweak_threshold'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__tweak_threshold = new long[]{9748, 9804};

	/**
	 * Field descriptor (offset) for struct member 'navigation_mode'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__navigation_mode);
	 * CPointer&lt;Byte&gt; p_navigation_mode = p.cast(new Class[]{Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'navigation_mode'</li>
	 * <li>Signature: 'char'</li>
	 * <li>Actual Size (32bit/64bit): 1/1</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__navigation_mode = new long[]{9750, 9806};

	/**
	 * Field descriptor (offset) for struct member 'pad'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__pad);
	 * CPointer&lt;Byte&gt; p_pad = p.cast(new Class[]{Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'pad'</li>
	 * <li>Signature: 'char'</li>
	 * <li>Actual Size (32bit/64bit): 1/1</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__pad = new long[]{9751, 9807};

	/**
	 * Field descriptor (offset) for struct member 'author'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> author name for file formats supporting it </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__author);
	 * CPointer&lt;CArrayFacade&lt;Byte&gt;&gt; p_author = p.cast(new Class[]{CArrayFacade.class, Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'author'</li>
	 * <li>Signature: 'char[80]'</li>
	 * <li>Actual Size (32bit/64bit): 80/80</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__author = new long[]{9752, 9808};

	/**
	 * Field descriptor (offset) for struct member 'font_path_ui'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__font_path_ui);
	 * CPointer&lt;CArrayFacade&lt;Byte&gt;&gt; p_font_path_ui = p.cast(new Class[]{CArrayFacade.class, Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'font_path_ui'</li>
	 * <li>Signature: 'char[1024]'</li>
	 * <li>Actual Size (32bit/64bit): 1024/1024</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__font_path_ui = new long[]{9832, 9888};

	/**
	 * Field descriptor (offset) for struct member 'font_path_ui_mono'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__font_path_ui_mono);
	 * CPointer&lt;CArrayFacade&lt;Byte&gt;&gt; p_font_path_ui_mono = p.cast(new Class[]{CArrayFacade.class, Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'font_path_ui_mono'</li>
	 * <li>Signature: 'char[1024]'</li>
	 * <li>Actual Size (32bit/64bit): 1024/1024</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__font_path_ui_mono = new long[]{10856, 10912};

	/**
	 * Field descriptor (offset) for struct member 'compute_device_type'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__compute_device_type);
	 * CPointer&lt;Integer&gt; p_compute_device_type = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'compute_device_type'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__compute_device_type = new long[]{11880, 11936};

	/**
	 * Field descriptor (offset) for struct member 'compute_device_id'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__compute_device_id);
	 * CPointer&lt;Integer&gt; p_compute_device_id = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'compute_device_id'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__compute_device_id = new long[]{11884, 11940};

	/**
	 * Field descriptor (offset) for struct member 'fcu_inactive_alpha'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> opacity of inactive F-Curves in F-Curve Editor </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__fcu_inactive_alpha);
	 * CPointer&lt;Float&gt; p_fcu_inactive_alpha = p.cast(new Class[]{Float.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'fcu_inactive_alpha'</li>
	 * <li>Signature: 'float'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__fcu_inactive_alpha = new long[]{11888, 11944};

	/**
	 * Field descriptor (offset) for struct member 'pixelsize'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> private, set by GHOST, to multiply DPI with </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__pixelsize);
	 * CPointer&lt;Float&gt; p_pixelsize = p.cast(new Class[]{Float.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'pixelsize'</li>
	 * <li>Signature: 'float'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__pixelsize = new long[]{11892, 11948};

	/**
	 * Field descriptor (offset) for struct member 'virtual_pixel'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> virtual pixelsize mode </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__virtual_pixel);
	 * CPointer&lt;Integer&gt; p_virtual_pixel = p.cast(new Class[]{Integer.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'virtual_pixel'</li>
	 * <li>Signature: 'int'</li>
	 * <li>Actual Size (32bit/64bit): 4/4</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__virtual_pixel = new long[]{11896, 11952};

	/**
	 * Field descriptor (offset) for struct member 'pie_interaction_type'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> if keeping a pie menu spawn button pressed after this time, it turns into a drag/release pie menu </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__pie_interaction_type);
	 * CPointer&lt;Short&gt; p_pie_interaction_type = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'pie_interaction_type'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__pie_interaction_type = new long[]{11900, 11956};

	/**
	 * Field descriptor (offset) for struct member 'pie_initial_timeout'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> direction in the pie menu will always be calculated from the initial position within this time limit </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__pie_initial_timeout);
	 * CPointer&lt;Short&gt; p_pie_initial_timeout = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'pie_initial_timeout'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__pie_initial_timeout = new long[]{11902, 11958};

	/**
	 * Field descriptor (offset) for struct member 'pie_animation_timeout'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__pie_animation_timeout);
	 * CPointer&lt;Short&gt; p_pie_animation_timeout = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'pie_animation_timeout'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__pie_animation_timeout = new long[]{11904, 11960};

	/**
	 * Field descriptor (offset) for struct member 'pie_menu_confirm'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__pie_menu_confirm);
	 * CPointer&lt;Short&gt; p_pie_menu_confirm = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'pie_menu_confirm'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__pie_menu_confirm = new long[]{11906, 11962};

	/**
	 * Field descriptor (offset) for struct member 'pie_menu_radius'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> pie menu radius </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__pie_menu_radius);
	 * CPointer&lt;Short&gt; p_pie_menu_radius = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'pie_menu_radius'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__pie_menu_radius = new long[]{11908, 11964};

	/**
	 * Field descriptor (offset) for struct member 'pie_menu_threshold'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> pie menu distance from center before a direction is set </p>
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__pie_menu_threshold);
	 * CPointer&lt;Short&gt; p_pie_menu_threshold = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'pie_menu_threshold'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__pie_menu_threshold = new long[]{11910, 11966};

	/**
	 * Field descriptor (offset) for struct member 'walk_navigation'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__walk_navigation);
	 * CPointer&lt;WalkNavigation&gt; p_walk_navigation = p.cast(new Class[]{WalkNavigation.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'walk_navigation'</li>
	 * <li>Signature: 'WalkNavigation'</li>
	 * <li>Actual Size (32bit/64bit): 32/32</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__walk_navigation = new long[]{11912, 11968};

	/**
	 * Field descriptor (offset) for struct member 'opensubdiv_compute_type'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__opensubdiv_compute_type);
	 * CPointer&lt;Short&gt; p_opensubdiv_compute_type = p.cast(new Class[]{Short.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'opensubdiv_compute_type'</li>
	 * <li>Signature: 'short'</li>
	 * <li>Actual Size (32bit/64bit): 2/2</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__opensubdiv_compute_type = new long[]{11944, 12000};

	/**
	 * Field descriptor (offset) for struct member 'pad5'.
	 * <h3>Pointer Arithmetics</h3>
	 * <p>
	 * This is how you get a reference on the corresponding field in the struct:
	 * </p>
	 * <pre>
	 * UserDef userdef = ...;
	 * CPointer&lt;Object&gt; p = userdef.__dna__addressof(UserDef.__DNA__FIELD__pad5);
	 * CPointer&lt;CArrayFacade&lt;Byte&gt;&gt; p_pad5 = p.cast(new Class[]{CArrayFacade.class, Byte.class});
	 * </pre>
	 * <h3>Metadata</h3>
	 * <ul>
	 * <li>Field: 'pad5'</li>
	 * <li>Signature: 'char[6]'</li>
	 * <li>Actual Size (32bit/64bit): 6/6</li>
	 * </ul>
	 */
	public static final long[] __DNA__FIELD__pad5 = new long[]{11946, 12002};

	public UserDef(long __address, Block __block, BlockTable __blockTable) {
		super(__address, __block, __blockTable);
	}

	protected UserDef(UserDef that) {
		super(that.__io__address, that.__io__block, that.__io__blockTable);
	}

	/**
	 * Get method for struct member 'versionfile'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p>{@link UserDef}  has separate do-version handling, and can be read from other files </p>
	 * @see #__DNA__FIELD__versionfile
	 */
	
	public int getVersionfile() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 0);
		} else {
			return __io__block.readInt(__io__address + 0);
		}
	}

	/**
	 * Set method for struct member 'versionfile'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p>{@link UserDef}  has separate do-version handling, and can be read from other files </p>
	 * @see #__DNA__FIELD__versionfile
	 */
	
	public void setVersionfile(int versionfile) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 0, versionfile);
		} else {
			__io__block.writeInt(__io__address + 0, versionfile);
		}
	}

	/**
	 * Get method for struct member 'subversionfile'.
	 * @see #__DNA__FIELD__subversionfile
	 */
	
	public int getSubversionfile() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 4);
		} else {
			return __io__block.readInt(__io__address + 4);
		}
	}

	/**
	 * Set method for struct member 'subversionfile'.
	 * @see #__DNA__FIELD__subversionfile
	 */
	
	public void setSubversionfile(int subversionfile) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 4, subversionfile);
		} else {
			__io__block.writeInt(__io__address + 4, subversionfile);
		}
	}

	/**
	 * Get method for struct member 'flag'.
	 * @see #__DNA__FIELD__flag
	 */
	
	public int getFlag() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8);
		} else {
			return __io__block.readInt(__io__address + 8);
		}
	}

	/**
	 * Set method for struct member 'flag'.
	 * @see #__DNA__FIELD__flag
	 */
	
	public void setFlag(int flag) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8, flag);
		} else {
			__io__block.writeInt(__io__address + 8, flag);
		}
	}

	/**
	 * Get method for struct member 'dupflag'.
	 * @see #__DNA__FIELD__dupflag
	 */
	
	public int getDupflag() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 12);
		} else {
			return __io__block.readInt(__io__address + 12);
		}
	}

	/**
	 * Set method for struct member 'dupflag'.
	 * @see #__DNA__FIELD__dupflag
	 */
	
	public void setDupflag(int dupflag) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 12, dupflag);
		} else {
			__io__block.writeInt(__io__address + 12, dupflag);
		}
	}

	/**
	 * Get method for struct member 'savetime'.
	 * @see #__DNA__FIELD__savetime
	 */
	
	public int getSavetime() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 16);
		} else {
			return __io__block.readInt(__io__address + 16);
		}
	}

	/**
	 * Set method for struct member 'savetime'.
	 * @see #__DNA__FIELD__savetime
	 */
	
	public void setSavetime(int savetime) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 16, savetime);
		} else {
			__io__block.writeInt(__io__address + 16, savetime);
		}
	}

	/**
	 * Get method for struct member 'tempdir'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> FILE_MAXDIR length </p>
	 * @see #__DNA__FIELD__tempdir
	 */
	
	public CArrayFacade<Byte> getTempdir() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
		int[] __dna__dimensions = new int[]{
			768
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Byte>(__io__address + 20, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Byte>(__io__address + 20, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'tempdir'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> FILE_MAXDIR length </p>
	 * @see #__DNA__FIELD__tempdir
	 */
	
	public void setTempdir(CArrayFacade<Byte> tempdir) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 20;
		} else {
			__dna__offset = 20;
		}
		if (__io__equals(tempdir, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, tempdir)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, tempdir);
		} else {
			__io__generic__copy( getTempdir(), tempdir);
		}
	}

	/**
	 * Get method for struct member 'fontdir'.
	 * @see #__DNA__FIELD__fontdir
	 */
	
	public CArrayFacade<Byte> getFontdir() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
		int[] __dna__dimensions = new int[]{
			768
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Byte>(__io__address + 788, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Byte>(__io__address + 788, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'fontdir'.
	 * @see #__DNA__FIELD__fontdir
	 */
	
	public void setFontdir(CArrayFacade<Byte> fontdir) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 788;
		} else {
			__dna__offset = 788;
		}
		if (__io__equals(fontdir, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, fontdir)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, fontdir);
		} else {
			__io__generic__copy( getFontdir(), fontdir);
		}
	}

	/**
	 * Get method for struct member 'renderdir'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> FILE_MAX length </p>
	 * @see #__DNA__FIELD__renderdir
	 */
	
	public CArrayFacade<Byte> getRenderdir() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
		int[] __dna__dimensions = new int[]{
			1024
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Byte>(__io__address + 1556, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Byte>(__io__address + 1556, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'renderdir'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> FILE_MAX length </p>
	 * @see #__DNA__FIELD__renderdir
	 */
	
	public void setRenderdir(CArrayFacade<Byte> renderdir) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 1556;
		} else {
			__dna__offset = 1556;
		}
		if (__io__equals(renderdir, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, renderdir)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, renderdir);
		} else {
			__io__generic__copy( getRenderdir(), renderdir);
		}
	}

	/**
	 * Get method for struct member 'render_cachedir'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> EXR cache path 768 = FILE_MAXDIR </p>
	 * @see #__DNA__FIELD__render_cachedir
	 */
	
	public CArrayFacade<Byte> getRender_cachedir() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
		int[] __dna__dimensions = new int[]{
			768
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Byte>(__io__address + 2580, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Byte>(__io__address + 2580, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'render_cachedir'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> EXR cache path 768 = FILE_MAXDIR </p>
	 * @see #__DNA__FIELD__render_cachedir
	 */
	
	public void setRender_cachedir(CArrayFacade<Byte> render_cachedir) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 2580;
		} else {
			__dna__offset = 2580;
		}
		if (__io__equals(render_cachedir, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, render_cachedir)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, render_cachedir);
		} else {
			__io__generic__copy( getRender_cachedir(), render_cachedir);
		}
	}

	/**
	 * Get method for struct member 'textudir'.
	 * @see #__DNA__FIELD__textudir
	 */
	
	public CArrayFacade<Byte> getTextudir() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
		int[] __dna__dimensions = new int[]{
			768
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Byte>(__io__address + 3348, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Byte>(__io__address + 3348, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'textudir'.
	 * @see #__DNA__FIELD__textudir
	 */
	
	public void setTextudir(CArrayFacade<Byte> textudir) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 3348;
		} else {
			__dna__offset = 3348;
		}
		if (__io__equals(textudir, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, textudir)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, textudir);
		} else {
			__io__generic__copy( getTextudir(), textudir);
		}
	}

	/**
	 * Get method for struct member 'pythondir'.
	 * @see #__DNA__FIELD__pythondir
	 */
	
	public CArrayFacade<Byte> getPythondir() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
		int[] __dna__dimensions = new int[]{
			768
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Byte>(__io__address + 4116, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Byte>(__io__address + 4116, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'pythondir'.
	 * @see #__DNA__FIELD__pythondir
	 */
	
	public void setPythondir(CArrayFacade<Byte> pythondir) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 4116;
		} else {
			__dna__offset = 4116;
		}
		if (__io__equals(pythondir, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, pythondir)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, pythondir);
		} else {
			__io__generic__copy( getPythondir(), pythondir);
		}
	}

	/**
	 * Get method for struct member 'sounddir'.
	 * @see #__DNA__FIELD__sounddir
	 */
	
	public CArrayFacade<Byte> getSounddir() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
		int[] __dna__dimensions = new int[]{
			768
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Byte>(__io__address + 4884, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Byte>(__io__address + 4884, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'sounddir'.
	 * @see #__DNA__FIELD__sounddir
	 */
	
	public void setSounddir(CArrayFacade<Byte> sounddir) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 4884;
		} else {
			__dna__offset = 4884;
		}
		if (__io__equals(sounddir, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, sounddir)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, sounddir);
		} else {
			__io__generic__copy( getSounddir(), sounddir);
		}
	}

	/**
	 * Get method for struct member 'i18ndir'.
	 * @see #__DNA__FIELD__i18ndir
	 */
	
	public CArrayFacade<Byte> getI18ndir() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
		int[] __dna__dimensions = new int[]{
			768
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Byte>(__io__address + 5652, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Byte>(__io__address + 5652, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'i18ndir'.
	 * @see #__DNA__FIELD__i18ndir
	 */
	
	public void setI18ndir(CArrayFacade<Byte> i18ndir) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 5652;
		} else {
			__dna__offset = 5652;
		}
		if (__io__equals(i18ndir, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, i18ndir)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, i18ndir);
		} else {
			__io__generic__copy( getI18ndir(), i18ndir);
		}
	}

	/**
	 * Get method for struct member 'image_editor'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> 1024 = FILE_MAX </p>
	 * @see #__DNA__FIELD__image_editor
	 */
	
	public CArrayFacade<Byte> getImage_editor() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
		int[] __dna__dimensions = new int[]{
			1024
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Byte>(__io__address + 6420, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Byte>(__io__address + 6420, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'image_editor'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> 1024 = FILE_MAX </p>
	 * @see #__DNA__FIELD__image_editor
	 */
	
	public void setImage_editor(CArrayFacade<Byte> image_editor) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 6420;
		} else {
			__dna__offset = 6420;
		}
		if (__io__equals(image_editor, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, image_editor)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, image_editor);
		} else {
			__io__generic__copy( getImage_editor(), image_editor);
		}
	}

	/**
	 * Get method for struct member 'anim_player'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> 1024 = FILE_MAX </p>
	 * @see #__DNA__FIELD__anim_player
	 */
	
	public CArrayFacade<Byte> getAnim_player() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
		int[] __dna__dimensions = new int[]{
			1024
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Byte>(__io__address + 7444, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Byte>(__io__address + 7444, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'anim_player'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> 1024 = FILE_MAX </p>
	 * @see #__DNA__FIELD__anim_player
	 */
	
	public void setAnim_player(CArrayFacade<Byte> anim_player) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 7444;
		} else {
			__dna__offset = 7444;
		}
		if (__io__equals(anim_player, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, anim_player)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, anim_player);
		} else {
			__io__generic__copy( getAnim_player(), anim_player);
		}
	}

	/**
	 * Get method for struct member 'anim_player_preset'.
	 * @see #__DNA__FIELD__anim_player_preset
	 */
	
	public int getAnim_player_preset() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8468);
		} else {
			return __io__block.readInt(__io__address + 8468);
		}
	}

	/**
	 * Set method for struct member 'anim_player_preset'.
	 * @see #__DNA__FIELD__anim_player_preset
	 */
	
	public void setAnim_player_preset(int anim_player_preset) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8468, anim_player_preset);
		} else {
			__io__block.writeInt(__io__address + 8468, anim_player_preset);
		}
	}

	/**
	 * Get method for struct member 'v2d_min_gridsize'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> minimum spacing between gridlines in {@link View2D}  grids </p>
	 * @see #__DNA__FIELD__v2d_min_gridsize
	 */
	
	public short getV2d_min_gridsize() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8472);
		} else {
			return __io__block.readShort(__io__address + 8472);
		}
	}

	/**
	 * Set method for struct member 'v2d_min_gridsize'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> minimum spacing between gridlines in {@link View2D}  grids </p>
	 * @see #__DNA__FIELD__v2d_min_gridsize
	 */
	
	public void setV2d_min_gridsize(short v2d_min_gridsize) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8472, v2d_min_gridsize);
		} else {
			__io__block.writeShort(__io__address + 8472, v2d_min_gridsize);
		}
	}

	/**
	 * Get method for struct member 'timecode_style'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> style of timecode display </p>
	 * @see #__DNA__FIELD__timecode_style
	 */
	
	public short getTimecode_style() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8474);
		} else {
			return __io__block.readShort(__io__address + 8474);
		}
	}

	/**
	 * Set method for struct member 'timecode_style'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> style of timecode display </p>
	 * @see #__DNA__FIELD__timecode_style
	 */
	
	public void setTimecode_style(short timecode_style) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8474, timecode_style);
		} else {
			__io__block.writeShort(__io__address + 8474, timecode_style);
		}
	}

	/**
	 * Get method for struct member 'versions'.
	 * @see #__DNA__FIELD__versions
	 */
	
	public short getVersions() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8476);
		} else {
			return __io__block.readShort(__io__address + 8476);
		}
	}

	/**
	 * Set method for struct member 'versions'.
	 * @see #__DNA__FIELD__versions
	 */
	
	public void setVersions(short versions) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8476, versions);
		} else {
			__io__block.writeShort(__io__address + 8476, versions);
		}
	}

	/**
	 * Get method for struct member 'dbl_click_time'.
	 * @see #__DNA__FIELD__dbl_click_time
	 */
	
	public short getDbl_click_time() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8478);
		} else {
			return __io__block.readShort(__io__address + 8478);
		}
	}

	/**
	 * Set method for struct member 'dbl_click_time'.
	 * @see #__DNA__FIELD__dbl_click_time
	 */
	
	public void setDbl_click_time(short dbl_click_time) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8478, dbl_click_time);
		} else {
			__io__block.writeShort(__io__address + 8478, dbl_click_time);
		}
	}

	/**
	 * Get method for struct member 'gameflags'.
	 * @see #__DNA__FIELD__gameflags
	 */
	
	public short getGameflags() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8480);
		} else {
			return __io__block.readShort(__io__address + 8480);
		}
	}

	/**
	 * Set method for struct member 'gameflags'.
	 * @see #__DNA__FIELD__gameflags
	 */
	
	public void setGameflags(short gameflags) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8480, gameflags);
		} else {
			__io__block.writeShort(__io__address + 8480, gameflags);
		}
	}

	/**
	 * Get method for struct member 'wheellinescroll'.
	 * @see #__DNA__FIELD__wheellinescroll
	 */
	
	public short getWheellinescroll() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8482);
		} else {
			return __io__block.readShort(__io__address + 8482);
		}
	}

	/**
	 * Set method for struct member 'wheellinescroll'.
	 * @see #__DNA__FIELD__wheellinescroll
	 */
	
	public void setWheellinescroll(short wheellinescroll) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8482, wheellinescroll);
		} else {
			__io__block.writeShort(__io__address + 8482, wheellinescroll);
		}
	}

	/**
	 * Get method for struct member 'uiflag'.
	 * @see #__DNA__FIELD__uiflag
	 */
	
	public int getUiflag() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8484);
		} else {
			return __io__block.readInt(__io__address + 8484);
		}
	}

	/**
	 * Set method for struct member 'uiflag'.
	 * @see #__DNA__FIELD__uiflag
	 */
	
	public void setUiflag(int uiflag) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8484, uiflag);
		} else {
			__io__block.writeInt(__io__address + 8484, uiflag);
		}
	}

	/**
	 * Get method for struct member 'uiflag2'.
	 * @see #__DNA__FIELD__uiflag2
	 */
	
	public int getUiflag2() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8488);
		} else {
			return __io__block.readInt(__io__address + 8488);
		}
	}

	/**
	 * Set method for struct member 'uiflag2'.
	 * @see #__DNA__FIELD__uiflag2
	 */
	
	public void setUiflag2(int uiflag2) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8488, uiflag2);
		} else {
			__io__block.writeInt(__io__address + 8488, uiflag2);
		}
	}

	/**
	 * Get method for struct member 'language'.
	 * @see #__DNA__FIELD__language
	 */
	
	public int getLanguage() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8492);
		} else {
			return __io__block.readInt(__io__address + 8492);
		}
	}

	/**
	 * Set method for struct member 'language'.
	 * @see #__DNA__FIELD__language
	 */
	
	public void setLanguage(int language) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8492, language);
		} else {
			__io__block.writeInt(__io__address + 8492, language);
		}
	}

	/**
	 * Get method for struct member 'userpref'.
	 * @see #__DNA__FIELD__userpref
	 */
	
	public short getUserpref() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8496);
		} else {
			return __io__block.readShort(__io__address + 8496);
		}
	}

	/**
	 * Set method for struct member 'userpref'.
	 * @see #__DNA__FIELD__userpref
	 */
	
	public void setUserpref(short userpref) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8496, userpref);
		} else {
			__io__block.writeShort(__io__address + 8496, userpref);
		}
	}

	/**
	 * Get method for struct member 'viewzoom'.
	 * @see #__DNA__FIELD__viewzoom
	 */
	
	public short getViewzoom() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8498);
		} else {
			return __io__block.readShort(__io__address + 8498);
		}
	}

	/**
	 * Set method for struct member 'viewzoom'.
	 * @see #__DNA__FIELD__viewzoom
	 */
	
	public void setViewzoom(short viewzoom) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8498, viewzoom);
		} else {
			__io__block.writeShort(__io__address + 8498, viewzoom);
		}
	}

	/**
	 * Get method for struct member 'mixbufsize'.
	 * @see #__DNA__FIELD__mixbufsize
	 */
	
	public int getMixbufsize() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8500);
		} else {
			return __io__block.readInt(__io__address + 8500);
		}
	}

	/**
	 * Set method for struct member 'mixbufsize'.
	 * @see #__DNA__FIELD__mixbufsize
	 */
	
	public void setMixbufsize(int mixbufsize) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8500, mixbufsize);
		} else {
			__io__block.writeInt(__io__address + 8500, mixbufsize);
		}
	}

	/**
	 * Get method for struct member 'audiodevice'.
	 * @see #__DNA__FIELD__audiodevice
	 */
	
	public int getAudiodevice() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8504);
		} else {
			return __io__block.readInt(__io__address + 8504);
		}
	}

	/**
	 * Set method for struct member 'audiodevice'.
	 * @see #__DNA__FIELD__audiodevice
	 */
	
	public void setAudiodevice(int audiodevice) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8504, audiodevice);
		} else {
			__io__block.writeInt(__io__address + 8504, audiodevice);
		}
	}

	/**
	 * Get method for struct member 'audiorate'.
	 * @see #__DNA__FIELD__audiorate
	 */
	
	public int getAudiorate() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8508);
		} else {
			return __io__block.readInt(__io__address + 8508);
		}
	}

	/**
	 * Set method for struct member 'audiorate'.
	 * @see #__DNA__FIELD__audiorate
	 */
	
	public void setAudiorate(int audiorate) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8508, audiorate);
		} else {
			__io__block.writeInt(__io__address + 8508, audiorate);
		}
	}

	/**
	 * Get method for struct member 'audioformat'.
	 * @see #__DNA__FIELD__audioformat
	 */
	
	public int getAudioformat() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8512);
		} else {
			return __io__block.readInt(__io__address + 8512);
		}
	}

	/**
	 * Set method for struct member 'audioformat'.
	 * @see #__DNA__FIELD__audioformat
	 */
	
	public void setAudioformat(int audioformat) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8512, audioformat);
		} else {
			__io__block.writeInt(__io__address + 8512, audioformat);
		}
	}

	/**
	 * Get method for struct member 'audiochannels'.
	 * @see #__DNA__FIELD__audiochannels
	 */
	
	public int getAudiochannels() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8516);
		} else {
			return __io__block.readInt(__io__address + 8516);
		}
	}

	/**
	 * Set method for struct member 'audiochannels'.
	 * @see #__DNA__FIELD__audiochannels
	 */
	
	public void setAudiochannels(int audiochannels) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8516, audiochannels);
		} else {
			__io__block.writeInt(__io__address + 8516, audiochannels);
		}
	}

	/**
	 * Get method for struct member 'scrollback'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> console scrollback limit </p>
	 * @see #__DNA__FIELD__scrollback
	 */
	
	public int getScrollback() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8520);
		} else {
			return __io__block.readInt(__io__address + 8520);
		}
	}

	/**
	 * Set method for struct member 'scrollback'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> console scrollback limit </p>
	 * @see #__DNA__FIELD__scrollback
	 */
	
	public void setScrollback(int scrollback) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8520, scrollback);
		} else {
			__io__block.writeInt(__io__address + 8520, scrollback);
		}
	}

	/**
	 * Get method for struct member 'dpi'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> range 48-128? </p>
	 * @see #__DNA__FIELD__dpi
	 */
	
	public int getDpi() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8524);
		} else {
			return __io__block.readInt(__io__address + 8524);
		}
	}

	/**
	 * Set method for struct member 'dpi'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> range 48-128? </p>
	 * @see #__DNA__FIELD__dpi
	 */
	
	public void setDpi(int dpi) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8524, dpi);
		} else {
			__io__block.writeInt(__io__address + 8524, dpi);
		}
	}

	/**
	 * Get method for struct member 'node_margin'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> node insert offset (aka auto-offset) margin, but might be useful for later stuff as well </p>
	 * @see #__DNA__FIELD__node_margin
	 */
	
	public byte getNode_margin() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readByte(__io__address + 8528);
		} else {
			return __io__block.readByte(__io__address + 8528);
		}
	}

	/**
	 * Set method for struct member 'node_margin'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> node insert offset (aka auto-offset) margin, but might be useful for later stuff as well </p>
	 * @see #__DNA__FIELD__node_margin
	 */
	
	public void setNode_margin(byte node_margin) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeByte(__io__address + 8528, node_margin);
		} else {
			__io__block.writeByte(__io__address + 8528, node_margin);
		}
	}

	/**
	 * Get method for struct member 'pad2'.
	 * @see #__DNA__FIELD__pad2
	 */
	
	public byte getPad2() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readByte(__io__address + 8529);
		} else {
			return __io__block.readByte(__io__address + 8529);
		}
	}

	/**
	 * Set method for struct member 'pad2'.
	 * @see #__DNA__FIELD__pad2
	 */
	
	public void setPad2(byte pad2) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeByte(__io__address + 8529, pad2);
		} else {
			__io__block.writeByte(__io__address + 8529, pad2);
		}
	}

	/**
	 * Get method for struct member 'transopts'.
	 * @see #__DNA__FIELD__transopts
	 */
	
	public short getTransopts() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8530);
		} else {
			return __io__block.readShort(__io__address + 8530);
		}
	}

	/**
	 * Set method for struct member 'transopts'.
	 * @see #__DNA__FIELD__transopts
	 */
	
	public void setTransopts(short transopts) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8530, transopts);
		} else {
			__io__block.writeShort(__io__address + 8530, transopts);
		}
	}

	/**
	 * Get method for struct member 'menuthreshold1'.
	 * @see #__DNA__FIELD__menuthreshold1
	 */
	
	public short getMenuthreshold1() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8532);
		} else {
			return __io__block.readShort(__io__address + 8532);
		}
	}

	/**
	 * Set method for struct member 'menuthreshold1'.
	 * @see #__DNA__FIELD__menuthreshold1
	 */
	
	public void setMenuthreshold1(short menuthreshold1) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8532, menuthreshold1);
		} else {
			__io__block.writeShort(__io__address + 8532, menuthreshold1);
		}
	}

	/**
	 * Get method for struct member 'menuthreshold2'.
	 * @see #__DNA__FIELD__menuthreshold2
	 */
	
	public short getMenuthreshold2() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8534);
		} else {
			return __io__block.readShort(__io__address + 8534);
		}
	}

	/**
	 * Set method for struct member 'menuthreshold2'.
	 * @see #__DNA__FIELD__menuthreshold2
	 */
	
	public void setMenuthreshold2(short menuthreshold2) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8534, menuthreshold2);
		} else {
			__io__block.writeShort(__io__address + 8534, menuthreshold2);
		}
	}

	/**
	 * Get method for struct member 'themes'.
	 * @see #__DNA__FIELD__themes
	 */
	
	public ListBase getThemes() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return new ListBase(__io__address + 8536, __io__block, __io__blockTable);
		} else {
			return new ListBase(__io__address + 8536, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'themes'.
	 * @see #__DNA__FIELD__themes
	 */
	
	public void setThemes(ListBase themes) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 8536;
		} else {
			__dna__offset = 8536;
		}
		if (__io__equals(themes, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, themes)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, themes);
		} else {
			__io__generic__copy( getThemes(), themes);
		}
	}

	/**
	 * Get method for struct member 'uifonts'.
	 * @see #__DNA__FIELD__uifonts
	 */
	
	public ListBase getUifonts() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return new ListBase(__io__address + 8552, __io__block, __io__blockTable);
		} else {
			return new ListBase(__io__address + 8544, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'uifonts'.
	 * @see #__DNA__FIELD__uifonts
	 */
	
	public void setUifonts(ListBase uifonts) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 8552;
		} else {
			__dna__offset = 8544;
		}
		if (__io__equals(uifonts, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, uifonts)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, uifonts);
		} else {
			__io__generic__copy( getUifonts(), uifonts);
		}
	}

	/**
	 * Get method for struct member 'uistyles'.
	 * @see #__DNA__FIELD__uistyles
	 */
	
	public ListBase getUistyles() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return new ListBase(__io__address + 8568, __io__block, __io__blockTable);
		} else {
			return new ListBase(__io__address + 8552, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'uistyles'.
	 * @see #__DNA__FIELD__uistyles
	 */
	
	public void setUistyles(ListBase uistyles) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 8568;
		} else {
			__dna__offset = 8552;
		}
		if (__io__equals(uistyles, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, uistyles)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, uistyles);
		} else {
			__io__generic__copy( getUistyles(), uistyles);
		}
	}

	/**
	 * Get method for struct member 'keymaps'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p><p> deprecated in favor of user_keymaps </p>
	 * @deprecated
	 *  Deprecateddeprecated in favor of user_keymaps </p>
	 * @see #__DNA__FIELD__keymaps
	 */
	
	public ListBase getKeymaps() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return new ListBase(__io__address + 8584, __io__block, __io__blockTable);
		} else {
			return new ListBase(__io__address + 8560, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'keymaps'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p><p> deprecated in favor of user_keymaps </p>
	 * @deprecated
	 *  Deprecateddeprecated in favor of user_keymaps </p>
	 * @see #__DNA__FIELD__keymaps
	 */
	
	public void setKeymaps(ListBase keymaps) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 8584;
		} else {
			__dna__offset = 8560;
		}
		if (__io__equals(keymaps, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, keymaps)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, keymaps);
		} else {
			__io__generic__copy( getKeymaps(), keymaps);
		}
	}

	/**
	 * Get method for struct member 'user_keymaps'.
	 * @see #__DNA__FIELD__user_keymaps
	 */
	
	public ListBase getUser_keymaps() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return new ListBase(__io__address + 8600, __io__block, __io__blockTable);
		} else {
			return new ListBase(__io__address + 8568, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'user_keymaps'.
	 * @see #__DNA__FIELD__user_keymaps
	 */
	
	public void setUser_keymaps(ListBase user_keymaps) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 8600;
		} else {
			__dna__offset = 8568;
		}
		if (__io__equals(user_keymaps, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, user_keymaps)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, user_keymaps);
		} else {
			__io__generic__copy( getUser_keymaps(), user_keymaps);
		}
	}

	/**
	 * Get method for struct member 'addons'.
	 * @see #__DNA__FIELD__addons
	 */
	
	public ListBase getAddons() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return new ListBase(__io__address + 8616, __io__block, __io__blockTable);
		} else {
			return new ListBase(__io__address + 8576, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'addons'.
	 * @see #__DNA__FIELD__addons
	 */
	
	public void setAddons(ListBase addons) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 8616;
		} else {
			__dna__offset = 8576;
		}
		if (__io__equals(addons, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, addons)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, addons);
		} else {
			__io__generic__copy( getAddons(), addons);
		}
	}

	/**
	 * Get method for struct member 'autoexec_paths'.
	 * @see #__DNA__FIELD__autoexec_paths
	 */
	
	public ListBase getAutoexec_paths() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return new ListBase(__io__address + 8632, __io__block, __io__blockTable);
		} else {
			return new ListBase(__io__address + 8584, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'autoexec_paths'.
	 * @see #__DNA__FIELD__autoexec_paths
	 */
	
	public void setAutoexec_paths(ListBase autoexec_paths) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 8632;
		} else {
			__dna__offset = 8584;
		}
		if (__io__equals(autoexec_paths, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, autoexec_paths)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, autoexec_paths);
		} else {
			__io__generic__copy( getAutoexec_paths(), autoexec_paths);
		}
	}

	/**
	 * Get method for struct member 'keyconfigstr'.
	 * @see #__DNA__FIELD__keyconfigstr
	 */
	
	public CArrayFacade<Byte> getKeyconfigstr() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
		int[] __dna__dimensions = new int[]{
			64
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Byte>(__io__address + 8648, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Byte>(__io__address + 8592, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'keyconfigstr'.
	 * @see #__DNA__FIELD__keyconfigstr
	 */
	
	public void setKeyconfigstr(CArrayFacade<Byte> keyconfigstr) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 8648;
		} else {
			__dna__offset = 8592;
		}
		if (__io__equals(keyconfigstr, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, keyconfigstr)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, keyconfigstr);
		} else {
			__io__generic__copy( getKeyconfigstr(), keyconfigstr);
		}
	}

	/**
	 * Get method for struct member 'undosteps'.
	 * @see #__DNA__FIELD__undosteps
	 */
	
	public short getUndosteps() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8712);
		} else {
			return __io__block.readShort(__io__address + 8656);
		}
	}

	/**
	 * Set method for struct member 'undosteps'.
	 * @see #__DNA__FIELD__undosteps
	 */
	
	public void setUndosteps(short undosteps) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8712, undosteps);
		} else {
			__io__block.writeShort(__io__address + 8656, undosteps);
		}
	}

	/**
	 * Get method for struct member 'undomemory'.
	 * @see #__DNA__FIELD__undomemory
	 */
	
	public short getUndomemory() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8714);
		} else {
			return __io__block.readShort(__io__address + 8658);
		}
	}

	/**
	 * Set method for struct member 'undomemory'.
	 * @see #__DNA__FIELD__undomemory
	 */
	
	public void setUndomemory(short undomemory) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8714, undomemory);
		} else {
			__io__block.writeShort(__io__address + 8658, undomemory);
		}
	}

	/**
	 * Get method for struct member 'gp_manhattendist'.
	 * @see #__DNA__FIELD__gp_manhattendist
	 */
	
	public short getGp_manhattendist() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8716);
		} else {
			return __io__block.readShort(__io__address + 8660);
		}
	}

	/**
	 * Set method for struct member 'gp_manhattendist'.
	 * @see #__DNA__FIELD__gp_manhattendist
	 */
	
	public void setGp_manhattendist(short gp_manhattendist) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8716, gp_manhattendist);
		} else {
			__io__block.writeShort(__io__address + 8660, gp_manhattendist);
		}
	}

	/**
	 * Get method for struct member 'gp_euclideandist'.
	 * @see #__DNA__FIELD__gp_euclideandist
	 */
	
	public short getGp_euclideandist() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8718);
		} else {
			return __io__block.readShort(__io__address + 8662);
		}
	}

	/**
	 * Set method for struct member 'gp_euclideandist'.
	 * @see #__DNA__FIELD__gp_euclideandist
	 */
	
	public void setGp_euclideandist(short gp_euclideandist) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8718, gp_euclideandist);
		} else {
			__io__block.writeShort(__io__address + 8662, gp_euclideandist);
		}
	}

	/**
	 * Get method for struct member 'gp_eraser'.
	 * @see #__DNA__FIELD__gp_eraser
	 */
	
	public short getGp_eraser() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8720);
		} else {
			return __io__block.readShort(__io__address + 8664);
		}
	}

	/**
	 * Set method for struct member 'gp_eraser'.
	 * @see #__DNA__FIELD__gp_eraser
	 */
	
	public void setGp_eraser(short gp_eraser) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8720, gp_eraser);
		} else {
			__io__block.writeShort(__io__address + 8664, gp_eraser);
		}
	}

	/**
	 * Get method for struct member 'gp_settings'.
	 * @see #__DNA__FIELD__gp_settings
	 */
	
	public short getGp_settings() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8722);
		} else {
			return __io__block.readShort(__io__address + 8666);
		}
	}

	/**
	 * Set method for struct member 'gp_settings'.
	 * @see #__DNA__FIELD__gp_settings
	 */
	
	public void setGp_settings(short gp_settings) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8722, gp_settings);
		} else {
			__io__block.writeShort(__io__address + 8666, gp_settings);
		}
	}

	/**
	 * Get method for struct member 'tb_leftmouse'.
	 * @see #__DNA__FIELD__tb_leftmouse
	 */
	
	public short getTb_leftmouse() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8724);
		} else {
			return __io__block.readShort(__io__address + 8668);
		}
	}

	/**
	 * Set method for struct member 'tb_leftmouse'.
	 * @see #__DNA__FIELD__tb_leftmouse
	 */
	
	public void setTb_leftmouse(short tb_leftmouse) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8724, tb_leftmouse);
		} else {
			__io__block.writeShort(__io__address + 8668, tb_leftmouse);
		}
	}

	/**
	 * Get method for struct member 'tb_rightmouse'.
	 * @see #__DNA__FIELD__tb_rightmouse
	 */
	
	public short getTb_rightmouse() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8726);
		} else {
			return __io__block.readShort(__io__address + 8670);
		}
	}

	/**
	 * Set method for struct member 'tb_rightmouse'.
	 * @see #__DNA__FIELD__tb_rightmouse
	 */
	
	public void setTb_rightmouse(short tb_rightmouse) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8726, tb_rightmouse);
		} else {
			__io__block.writeShort(__io__address + 8670, tb_rightmouse);
		}
	}

	/**
	 * Get method for struct member 'light'.
	 * @see #__DNA__FIELD__light
	 */
	
	public CArrayFacade<SolidLight> getLight() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{SolidLight.class};
		int[] __dna__dimensions = new int[]{
			3
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<SolidLight>(__io__address + 8728, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<SolidLight>(__io__address + 8672, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'light'.
	 * @see #__DNA__FIELD__light
	 */
	
	public void setLight(CArrayFacade<SolidLight> light) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 8728;
		} else {
			__dna__offset = 8672;
		}
		if (__io__equals(light, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, light)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, light);
		} else {
			__io__generic__copy( getLight(), light);
		}
	}

	/**
	 * Get method for struct member 'tw_hotspot'.
	 * @see #__DNA__FIELD__tw_hotspot
	 */
	
	public short getTw_hotspot() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8896);
		} else {
			return __io__block.readShort(__io__address + 8840);
		}
	}

	/**
	 * Set method for struct member 'tw_hotspot'.
	 * @see #__DNA__FIELD__tw_hotspot
	 */
	
	public void setTw_hotspot(short tw_hotspot) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8896, tw_hotspot);
		} else {
			__io__block.writeShort(__io__address + 8840, tw_hotspot);
		}
	}

	/**
	 * Get method for struct member 'tw_flag'.
	 * @see #__DNA__FIELD__tw_flag
	 */
	
	public short getTw_flag() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8898);
		} else {
			return __io__block.readShort(__io__address + 8842);
		}
	}

	/**
	 * Set method for struct member 'tw_flag'.
	 * @see #__DNA__FIELD__tw_flag
	 */
	
	public void setTw_flag(short tw_flag) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8898, tw_flag);
		} else {
			__io__block.writeShort(__io__address + 8842, tw_flag);
		}
	}

	/**
	 * Get method for struct member 'tw_handlesize'.
	 * @see #__DNA__FIELD__tw_handlesize
	 */
	
	public short getTw_handlesize() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8900);
		} else {
			return __io__block.readShort(__io__address + 8844);
		}
	}

	/**
	 * Set method for struct member 'tw_handlesize'.
	 * @see #__DNA__FIELD__tw_handlesize
	 */
	
	public void setTw_handlesize(short tw_handlesize) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8900, tw_handlesize);
		} else {
			__io__block.writeShort(__io__address + 8844, tw_handlesize);
		}
	}

	/**
	 * Get method for struct member 'tw_size'.
	 * @see #__DNA__FIELD__tw_size
	 */
	
	public short getTw_size() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8902);
		} else {
			return __io__block.readShort(__io__address + 8846);
		}
	}

	/**
	 * Set method for struct member 'tw_size'.
	 * @see #__DNA__FIELD__tw_size
	 */
	
	public void setTw_size(short tw_size) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8902, tw_size);
		} else {
			__io__block.writeShort(__io__address + 8846, tw_size);
		}
	}

	/**
	 * Get method for struct member 'textimeout'.
	 * @see #__DNA__FIELD__textimeout
	 */
	
	public short getTextimeout() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8904);
		} else {
			return __io__block.readShort(__io__address + 8848);
		}
	}

	/**
	 * Set method for struct member 'textimeout'.
	 * @see #__DNA__FIELD__textimeout
	 */
	
	public void setTextimeout(short textimeout) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8904, textimeout);
		} else {
			__io__block.writeShort(__io__address + 8848, textimeout);
		}
	}

	/**
	 * Get method for struct member 'texcollectrate'.
	 * @see #__DNA__FIELD__texcollectrate
	 */
	
	public short getTexcollectrate() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8906);
		} else {
			return __io__block.readShort(__io__address + 8850);
		}
	}

	/**
	 * Set method for struct member 'texcollectrate'.
	 * @see #__DNA__FIELD__texcollectrate
	 */
	
	public void setTexcollectrate(short texcollectrate) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8906, texcollectrate);
		} else {
			__io__block.writeShort(__io__address + 8850, texcollectrate);
		}
	}

	/**
	 * Get method for struct member 'wmdrawmethod'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> removed wmpad </p>
	 * @see #__DNA__FIELD__wmdrawmethod
	 */
	
	public short getWmdrawmethod() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8908);
		} else {
			return __io__block.readShort(__io__address + 8852);
		}
	}

	/**
	 * Set method for struct member 'wmdrawmethod'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> removed wmpad </p>
	 * @see #__DNA__FIELD__wmdrawmethod
	 */
	
	public void setWmdrawmethod(short wmdrawmethod) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8908, wmdrawmethod);
		} else {
			__io__block.writeShort(__io__address + 8852, wmdrawmethod);
		}
	}

	/**
	 * Get method for struct member 'dragthreshold'.
	 * @see #__DNA__FIELD__dragthreshold
	 */
	
	public short getDragthreshold() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8910);
		} else {
			return __io__block.readShort(__io__address + 8854);
		}
	}

	/**
	 * Set method for struct member 'dragthreshold'.
	 * @see #__DNA__FIELD__dragthreshold
	 */
	
	public void setDragthreshold(short dragthreshold) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8910, dragthreshold);
		} else {
			__io__block.writeShort(__io__address + 8854, dragthreshold);
		}
	}

	/**
	 * Get method for struct member 'memcachelimit'.
	 * @see #__DNA__FIELD__memcachelimit
	 */
	
	public int getMemcachelimit() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8912);
		} else {
			return __io__block.readInt(__io__address + 8856);
		}
	}

	/**
	 * Set method for struct member 'memcachelimit'.
	 * @see #__DNA__FIELD__memcachelimit
	 */
	
	public void setMemcachelimit(int memcachelimit) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8912, memcachelimit);
		} else {
			__io__block.writeInt(__io__address + 8856, memcachelimit);
		}
	}

	/**
	 * Get method for struct member 'prefetchframes'.
	 * @see #__DNA__FIELD__prefetchframes
	 */
	
	public int getPrefetchframes() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8916);
		} else {
			return __io__block.readInt(__io__address + 8860);
		}
	}

	/**
	 * Set method for struct member 'prefetchframes'.
	 * @see #__DNA__FIELD__prefetchframes
	 */
	
	public void setPrefetchframes(int prefetchframes) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8916, prefetchframes);
		} else {
			__io__block.writeInt(__io__address + 8860, prefetchframes);
		}
	}

	/**
	 * Get method for struct member 'pad_rot_angle'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> control the rotation step of the view when PAD2, PAD4, PAD6&PAD8 is use </p>
	 * @see #__DNA__FIELD__pad_rot_angle
	 */
	
	public float getPad_rot_angle() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readFloat(__io__address + 8920);
		} else {
			return __io__block.readFloat(__io__address + 8864);
		}
	}

	/**
	 * Set method for struct member 'pad_rot_angle'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> control the rotation step of the view when PAD2, PAD4, PAD6&PAD8 is use </p>
	 * @see #__DNA__FIELD__pad_rot_angle
	 */
	
	public void setPad_rot_angle(float pad_rot_angle) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeFloat(__io__address + 8920, pad_rot_angle);
		} else {
			__io__block.writeFloat(__io__address + 8864, pad_rot_angle);
		}
	}

	/**
	 * Get method for struct member 'frameserverport'.
	 * @see #__DNA__FIELD__frameserverport
	 */
	
	public short getFrameserverport() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8924);
		} else {
			return __io__block.readShort(__io__address + 8868);
		}
	}

	/**
	 * Set method for struct member 'frameserverport'.
	 * @see #__DNA__FIELD__frameserverport
	 */
	
	public void setFrameserverport(short frameserverport) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8924, frameserverport);
		} else {
			__io__block.writeShort(__io__address + 8868, frameserverport);
		}
	}

	/**
	 * Get method for struct member 'pad4'.
	 * @see #__DNA__FIELD__pad4
	 */
	
	public short getPad4() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8926);
		} else {
			return __io__block.readShort(__io__address + 8870);
		}
	}

	/**
	 * Set method for struct member 'pad4'.
	 * @see #__DNA__FIELD__pad4
	 */
	
	public void setPad4(short pad4) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8926, pad4);
		} else {
			__io__block.writeShort(__io__address + 8870, pad4);
		}
	}

	/**
	 * Get method for struct member 'obcenter_dia'.
	 * @see #__DNA__FIELD__obcenter_dia
	 */
	
	public short getObcenter_dia() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8928);
		} else {
			return __io__block.readShort(__io__address + 8872);
		}
	}

	/**
	 * Set method for struct member 'obcenter_dia'.
	 * @see #__DNA__FIELD__obcenter_dia
	 */
	
	public void setObcenter_dia(short obcenter_dia) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8928, obcenter_dia);
		} else {
			__io__block.writeShort(__io__address + 8872, obcenter_dia);
		}
	}

	/**
	 * Get method for struct member 'rvisize'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> rotating view icon size </p>
	 * @see #__DNA__FIELD__rvisize
	 */
	
	public short getRvisize() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8930);
		} else {
			return __io__block.readShort(__io__address + 8874);
		}
	}

	/**
	 * Set method for struct member 'rvisize'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> rotating view icon size </p>
	 * @see #__DNA__FIELD__rvisize
	 */
	
	public void setRvisize(short rvisize) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8930, rvisize);
		} else {
			__io__block.writeShort(__io__address + 8874, rvisize);
		}
	}

	/**
	 * Get method for struct member 'rvibright'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> rotating view icon brightness </p>
	 * @see #__DNA__FIELD__rvibright
	 */
	
	public short getRvibright() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8932);
		} else {
			return __io__block.readShort(__io__address + 8876);
		}
	}

	/**
	 * Set method for struct member 'rvibright'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> rotating view icon brightness </p>
	 * @see #__DNA__FIELD__rvibright
	 */
	
	public void setRvibright(short rvibright) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8932, rvibright);
		} else {
			__io__block.writeShort(__io__address + 8876, rvibright);
		}
	}

	/**
	 * Get method for struct member 'recent_files'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> maximum number of recently used files to remember </p>
	 * @see #__DNA__FIELD__recent_files
	 */
	
	public short getRecent_files() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8934);
		} else {
			return __io__block.readShort(__io__address + 8878);
		}
	}

	/**
	 * Set method for struct member 'recent_files'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> maximum number of recently used files to remember </p>
	 * @see #__DNA__FIELD__recent_files
	 */
	
	public void setRecent_files(short recent_files) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8934, recent_files);
		} else {
			__io__block.writeShort(__io__address + 8878, recent_files);
		}
	}

	/**
	 * Get method for struct member 'smooth_viewtx'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> miliseconds to spend spinning the view </p>
	 * @see #__DNA__FIELD__smooth_viewtx
	 */
	
	public short getSmooth_viewtx() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8936);
		} else {
			return __io__block.readShort(__io__address + 8880);
		}
	}

	/**
	 * Set method for struct member 'smooth_viewtx'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> miliseconds to spend spinning the view </p>
	 * @see #__DNA__FIELD__smooth_viewtx
	 */
	
	public void setSmooth_viewtx(short smooth_viewtx) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8936, smooth_viewtx);
		} else {
			__io__block.writeShort(__io__address + 8880, smooth_viewtx);
		}
	}

	/**
	 * Get method for struct member 'glreslimit'.
	 * @see #__DNA__FIELD__glreslimit
	 */
	
	public short getGlreslimit() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8938);
		} else {
			return __io__block.readShort(__io__address + 8882);
		}
	}

	/**
	 * Set method for struct member 'glreslimit'.
	 * @see #__DNA__FIELD__glreslimit
	 */
	
	public void setGlreslimit(short glreslimit) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8938, glreslimit);
		} else {
			__io__block.writeShort(__io__address + 8882, glreslimit);
		}
	}

	/**
	 * Get method for struct member 'curssize'.
	 * @see #__DNA__FIELD__curssize
	 */
	
	public short getCurssize() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8940);
		} else {
			return __io__block.readShort(__io__address + 8884);
		}
	}

	/**
	 * Set method for struct member 'curssize'.
	 * @see #__DNA__FIELD__curssize
	 */
	
	public void setCurssize(short curssize) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8940, curssize);
		} else {
			__io__block.writeShort(__io__address + 8884, curssize);
		}
	}

	/**
	 * Get method for struct member 'color_picker_type'.
	 * @see #__DNA__FIELD__color_picker_type
	 */
	
	public short getColor_picker_type() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8942);
		} else {
			return __io__block.readShort(__io__address + 8886);
		}
	}

	/**
	 * Set method for struct member 'color_picker_type'.
	 * @see #__DNA__FIELD__color_picker_type
	 */
	
	public void setColor_picker_type(short color_picker_type) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8942, color_picker_type);
		} else {
			__io__block.writeShort(__io__address + 8886, color_picker_type);
		}
	}

	/**
	 * Get method for struct member 'ipo_new'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> interpolation mode for newly added F-Curves </p>
	 * @see #__DNA__FIELD__ipo_new
	 */
	
	public byte getIpo_new() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readByte(__io__address + 8944);
		} else {
			return __io__block.readByte(__io__address + 8888);
		}
	}

	/**
	 * Set method for struct member 'ipo_new'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> interpolation mode for newly added F-Curves </p>
	 * @see #__DNA__FIELD__ipo_new
	 */
	
	public void setIpo_new(byte ipo_new) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeByte(__io__address + 8944, ipo_new);
		} else {
			__io__block.writeByte(__io__address + 8888, ipo_new);
		}
	}

	/**
	 * Get method for struct member 'keyhandles_new'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> handle types for newly added keyframes </p>
	 * @see #__DNA__FIELD__keyhandles_new
	 */
	
	public byte getKeyhandles_new() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readByte(__io__address + 8945);
		} else {
			return __io__block.readByte(__io__address + 8889);
		}
	}

	/**
	 * Set method for struct member 'keyhandles_new'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> handle types for newly added keyframes </p>
	 * @see #__DNA__FIELD__keyhandles_new
	 */
	
	public void setKeyhandles_new(byte keyhandles_new) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeByte(__io__address + 8945, keyhandles_new);
		} else {
			__io__block.writeByte(__io__address + 8889, keyhandles_new);
		}
	}

	/**
	 * Get method for struct member 'gpu_select_method'.
	 * @see #__DNA__FIELD__gpu_select_method
	 */
	
	public byte getGpu_select_method() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readByte(__io__address + 8946);
		} else {
			return __io__block.readByte(__io__address + 8890);
		}
	}

	/**
	 * Set method for struct member 'gpu_select_method'.
	 * @see #__DNA__FIELD__gpu_select_method
	 */
	
	public void setGpu_select_method(byte gpu_select_method) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeByte(__io__address + 8946, gpu_select_method);
		} else {
			__io__block.writeByte(__io__address + 8890, gpu_select_method);
		}
	}

	/**
	 * Get method for struct member 'view_frame_type'.
	 * @see #__DNA__FIELD__view_frame_type
	 */
	
	public byte getView_frame_type() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readByte(__io__address + 8947);
		} else {
			return __io__block.readByte(__io__address + 8891);
		}
	}

	/**
	 * Set method for struct member 'view_frame_type'.
	 * @see #__DNA__FIELD__view_frame_type
	 */
	
	public void setView_frame_type(byte view_frame_type) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeByte(__io__address + 8947, view_frame_type);
		} else {
			__io__block.writeByte(__io__address + 8891, view_frame_type);
		}
	}

	/**
	 * Get method for struct member 'view_frame_keyframes'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> number of keyframes to zoom around current frame </p>
	 * @see #__DNA__FIELD__view_frame_keyframes
	 */
	
	public int getView_frame_keyframes() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8948);
		} else {
			return __io__block.readInt(__io__address + 8892);
		}
	}

	/**
	 * Set method for struct member 'view_frame_keyframes'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> number of keyframes to zoom around current frame </p>
	 * @see #__DNA__FIELD__view_frame_keyframes
	 */
	
	public void setView_frame_keyframes(int view_frame_keyframes) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8948, view_frame_keyframes);
		} else {
			__io__block.writeInt(__io__address + 8892, view_frame_keyframes);
		}
	}

	/**
	 * Get method for struct member 'view_frame_seconds'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> seconds to zoom around current frame </p>
	 * @see #__DNA__FIELD__view_frame_seconds
	 */
	
	public float getView_frame_seconds() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readFloat(__io__address + 8952);
		} else {
			return __io__block.readFloat(__io__address + 8896);
		}
	}

	/**
	 * Set method for struct member 'view_frame_seconds'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> seconds to zoom around current frame </p>
	 * @see #__DNA__FIELD__view_frame_seconds
	 */
	
	public void setView_frame_seconds(float view_frame_seconds) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeFloat(__io__address + 8952, view_frame_seconds);
		} else {
			__io__block.writeFloat(__io__address + 8896, view_frame_seconds);
		}
	}

	/**
	 * Get method for struct member 'scrcastfps'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> frame rate for screencast to be played back </p>
	 * @see #__DNA__FIELD__scrcastfps
	 */
	
	public short getScrcastfps() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8956);
		} else {
			return __io__block.readShort(__io__address + 8900);
		}
	}

	/**
	 * Set method for struct member 'scrcastfps'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> frame rate for screencast to be played back </p>
	 * @see #__DNA__FIELD__scrcastfps
	 */
	
	public void setScrcastfps(short scrcastfps) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8956, scrcastfps);
		} else {
			__io__block.writeShort(__io__address + 8900, scrcastfps);
		}
	}

	/**
	 * Get method for struct member 'scrcastwait'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> milliseconds between screencast snapshots </p>
	 * @see #__DNA__FIELD__scrcastwait
	 */
	
	public short getScrcastwait() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8958);
		} else {
			return __io__block.readShort(__io__address + 8902);
		}
	}

	/**
	 * Set method for struct member 'scrcastwait'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> milliseconds between screencast snapshots </p>
	 * @see #__DNA__FIELD__scrcastwait
	 */
	
	public void setScrcastwait(short scrcastwait) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8958, scrcastwait);
		} else {
			__io__block.writeShort(__io__address + 8902, scrcastwait);
		}
	}

	/**
	 * Get method for struct member 'widget_unit'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> private, defaults to 20 for 72 DPI setting </p>
	 * @see #__DNA__FIELD__widget_unit
	 */
	
	public short getWidget_unit() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8960);
		} else {
			return __io__block.readShort(__io__address + 8904);
		}
	}

	/**
	 * Set method for struct member 'widget_unit'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> private, defaults to 20 for 72 DPI setting </p>
	 * @see #__DNA__FIELD__widget_unit
	 */
	
	public void setWidget_unit(short widget_unit) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8960, widget_unit);
		} else {
			__io__block.writeShort(__io__address + 8904, widget_unit);
		}
	}

	/**
	 * Get method for struct member 'anisotropic_filter'.
	 * @see #__DNA__FIELD__anisotropic_filter
	 */
	
	public short getAnisotropic_filter() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8962);
		} else {
			return __io__block.readShort(__io__address + 8906);
		}
	}

	/**
	 * Set method for struct member 'anisotropic_filter'.
	 * @see #__DNA__FIELD__anisotropic_filter
	 */
	
	public void setAnisotropic_filter(short anisotropic_filter) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8962, anisotropic_filter);
		} else {
			__io__block.writeShort(__io__address + 8906, anisotropic_filter);
		}
	}

	/**
	 * Get method for struct member 'use_16bit_textures'.
	 * @see #__DNA__FIELD__use_16bit_textures
	 */
	
	public short getUse_16bit_textures() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8964);
		} else {
			return __io__block.readShort(__io__address + 8908);
		}
	}

	/**
	 * Set method for struct member 'use_16bit_textures'.
	 * @see #__DNA__FIELD__use_16bit_textures
	 */
	
	public void setUse_16bit_textures(short use_16bit_textures) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8964, use_16bit_textures);
		} else {
			__io__block.writeShort(__io__address + 8908, use_16bit_textures);
		}
	}

	/**
	 * Get method for struct member 'use_gpu_mipmap'.
	 * @see #__DNA__FIELD__use_gpu_mipmap
	 */
	
	public short getUse_gpu_mipmap() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8966);
		} else {
			return __io__block.readShort(__io__address + 8910);
		}
	}

	/**
	 * Set method for struct member 'use_gpu_mipmap'.
	 * @see #__DNA__FIELD__use_gpu_mipmap
	 */
	
	public void setUse_gpu_mipmap(short use_gpu_mipmap) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8966, use_gpu_mipmap);
		} else {
			__io__block.writeShort(__io__address + 8910, use_gpu_mipmap);
		}
	}

	/**
	 * Get method for struct member 'ndof_sensitivity'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> overall sensitivity of 3D mouse </p>
	 * @see #__DNA__FIELD__ndof_sensitivity
	 */
	
	public float getNdof_sensitivity() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readFloat(__io__address + 8968);
		} else {
			return __io__block.readFloat(__io__address + 8912);
		}
	}

	/**
	 * Set method for struct member 'ndof_sensitivity'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> overall sensitivity of 3D mouse </p>
	 * @see #__DNA__FIELD__ndof_sensitivity
	 */
	
	public void setNdof_sensitivity(float ndof_sensitivity) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeFloat(__io__address + 8968, ndof_sensitivity);
		} else {
			__io__block.writeFloat(__io__address + 8912, ndof_sensitivity);
		}
	}

	/**
	 * Get method for struct member 'ndof_orbit_sensitivity'.
	 * @see #__DNA__FIELD__ndof_orbit_sensitivity
	 */
	
	public float getNdof_orbit_sensitivity() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readFloat(__io__address + 8972);
		} else {
			return __io__block.readFloat(__io__address + 8916);
		}
	}

	/**
	 * Set method for struct member 'ndof_orbit_sensitivity'.
	 * @see #__DNA__FIELD__ndof_orbit_sensitivity
	 */
	
	public void setNdof_orbit_sensitivity(float ndof_orbit_sensitivity) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeFloat(__io__address + 8972, ndof_orbit_sensitivity);
		} else {
			__io__block.writeFloat(__io__address + 8916, ndof_orbit_sensitivity);
		}
	}

	/**
	 * Get method for struct member 'ndof_deadzone'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> deadzone of 3D mouse </p>
	 * @see #__DNA__FIELD__ndof_deadzone
	 */
	
	public float getNdof_deadzone() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readFloat(__io__address + 8976);
		} else {
			return __io__block.readFloat(__io__address + 8920);
		}
	}

	/**
	 * Set method for struct member 'ndof_deadzone'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> deadzone of 3D mouse </p>
	 * @see #__DNA__FIELD__ndof_deadzone
	 */
	
	public void setNdof_deadzone(float ndof_deadzone) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeFloat(__io__address + 8976, ndof_deadzone);
		} else {
			__io__block.writeFloat(__io__address + 8920, ndof_deadzone);
		}
	}

	/**
	 * Get method for struct member 'ndof_flag'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> flags for 3D mouse </p>
	 * @see #__DNA__FIELD__ndof_flag
	 */
	
	public int getNdof_flag() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 8980);
		} else {
			return __io__block.readInt(__io__address + 8924);
		}
	}

	/**
	 * Set method for struct member 'ndof_flag'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> flags for 3D mouse </p>
	 * @see #__DNA__FIELD__ndof_flag
	 */
	
	public void setNdof_flag(int ndof_flag) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 8980, ndof_flag);
		} else {
			__io__block.writeInt(__io__address + 8924, ndof_flag);
		}
	}

	/**
	 * Get method for struct member 'ogl_multisamples'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> amount of samples for OpenGL FSA, if zero no FSA </p>
	 * @see #__DNA__FIELD__ogl_multisamples
	 */
	
	public short getOgl_multisamples() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8984);
		} else {
			return __io__block.readShort(__io__address + 8928);
		}
	}

	/**
	 * Set method for struct member 'ogl_multisamples'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> amount of samples for OpenGL FSA, if zero no FSA </p>
	 * @see #__DNA__FIELD__ogl_multisamples
	 */
	
	public void setOgl_multisamples(short ogl_multisamples) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8984, ogl_multisamples);
		} else {
			__io__block.writeShort(__io__address + 8928, ogl_multisamples);
		}
	}

	/**
	 * Get method for struct member 'image_draw_method'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> Method to be used to draw the images (AUTO, GLSL, Textures or DrawPixels) </p>
	 * @see #__DNA__FIELD__image_draw_method
	 */
	
	public short getImage_draw_method() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8986);
		} else {
			return __io__block.readShort(__io__address + 8930);
		}
	}

	/**
	 * Set method for struct member 'image_draw_method'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> Method to be used to draw the images (AUTO, GLSL, Textures or DrawPixels) </p>
	 * @see #__DNA__FIELD__image_draw_method
	 */
	
	public void setImage_draw_method(short image_draw_method) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8986, image_draw_method);
		} else {
			__io__block.writeShort(__io__address + 8930, image_draw_method);
		}
	}

	/**
	 * Get method for struct member 'glalphaclip'.
	 * @see #__DNA__FIELD__glalphaclip
	 */
	
	public float getGlalphaclip() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readFloat(__io__address + 8988);
		} else {
			return __io__block.readFloat(__io__address + 8932);
		}
	}

	/**
	 * Set method for struct member 'glalphaclip'.
	 * @see #__DNA__FIELD__glalphaclip
	 */
	
	public void setGlalphaclip(float glalphaclip) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeFloat(__io__address + 8988, glalphaclip);
		} else {
			__io__block.writeFloat(__io__address + 8932, glalphaclip);
		}
	}

	/**
	 * Get method for struct member 'autokey_mode'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> autokeying mode </p>
	 * @see #__DNA__FIELD__autokey_mode
	 */
	
	public short getAutokey_mode() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8992);
		} else {
			return __io__block.readShort(__io__address + 8936);
		}
	}

	/**
	 * Set method for struct member 'autokey_mode'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> autokeying mode </p>
	 * @see #__DNA__FIELD__autokey_mode
	 */
	
	public void setAutokey_mode(short autokey_mode) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8992, autokey_mode);
		} else {
			__io__block.writeShort(__io__address + 8936, autokey_mode);
		}
	}

	/**
	 * Get method for struct member 'autokey_flag'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> flags for autokeying </p>
	 * @see #__DNA__FIELD__autokey_flag
	 */
	
	public short getAutokey_flag() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8994);
		} else {
			return __io__block.readShort(__io__address + 8938);
		}
	}

	/**
	 * Set method for struct member 'autokey_flag'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> flags for autokeying </p>
	 * @see #__DNA__FIELD__autokey_flag
	 */
	
	public void setAutokey_flag(short autokey_flag) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8994, autokey_flag);
		} else {
			__io__block.writeShort(__io__address + 8938, autokey_flag);
		}
	}

	/**
	 * Get method for struct member 'text_render'.
	 * @see #__DNA__FIELD__text_render
	 */
	
	public short getText_render() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8996);
		} else {
			return __io__block.readShort(__io__address + 8940);
		}
	}

	/**
	 * Set method for struct member 'text_render'.
	 * @see #__DNA__FIELD__text_render
	 */
	
	public void setText_render(short text_render) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8996, text_render);
		} else {
			__io__block.writeShort(__io__address + 8940, text_render);
		}
	}

	/**
	 * Get method for struct member 'pad9'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> options for text rendering </p>
	 * @see #__DNA__FIELD__pad9
	 */
	
	public short getPad9() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 8998);
		} else {
			return __io__block.readShort(__io__address + 8942);
		}
	}

	/**
	 * Set method for struct member 'pad9'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> options for text rendering </p>
	 * @see #__DNA__FIELD__pad9
	 */
	
	public void setPad9(short pad9) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 8998, pad9);
		} else {
			__io__block.writeShort(__io__address + 8942, pad9);
		}
	}

	/**
	 * Get method for struct member 'coba_weight'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> from texture.h </p>
	 * @see #__DNA__FIELD__coba_weight
	 */
	
	public ColorBand getCoba_weight() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return new ColorBand(__io__address + 9000, __io__block, __io__blockTable);
		} else {
			return new ColorBand(__io__address + 8944, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'coba_weight'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> from texture.h </p>
	 * @see #__DNA__FIELD__coba_weight
	 */
	
	public void setCoba_weight(ColorBand coba_weight) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 9000;
		} else {
			__dna__offset = 8944;
		}
		if (__io__equals(coba_weight, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, coba_weight)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, coba_weight);
		} else {
			__io__generic__copy( getCoba_weight(), coba_weight);
		}
	}

	/**
	 * Get method for struct member 'sculpt_paint_overlay_col'.
	 * @see #__DNA__FIELD__sculpt_paint_overlay_col
	 */
	
	public CArrayFacade<Float> getSculpt_paint_overlay_col() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Float.class};
		int[] __dna__dimensions = new int[]{
			3
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Float>(__io__address + 9776, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Float>(__io__address + 9720, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'sculpt_paint_overlay_col'.
	 * @see #__DNA__FIELD__sculpt_paint_overlay_col
	 */
	
	public void setSculpt_paint_overlay_col(CArrayFacade<Float> sculpt_paint_overlay_col) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 9776;
		} else {
			__dna__offset = 9720;
		}
		if (__io__equals(sculpt_paint_overlay_col, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, sculpt_paint_overlay_col)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, sculpt_paint_overlay_col);
		} else {
			__io__generic__copy( getSculpt_paint_overlay_col(), sculpt_paint_overlay_col);
		}
	}

	/**
	 * Get method for struct member 'gpencil_new_layer_col'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> default color for newly created Grease Pencil layers </p>
	 * @see #__DNA__FIELD__gpencil_new_layer_col
	 */
	
	public CArrayFacade<Float> getGpencil_new_layer_col() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Float.class};
		int[] __dna__dimensions = new int[]{
			4
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Float>(__io__address + 9788, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Float>(__io__address + 9732, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'gpencil_new_layer_col'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> default color for newly created Grease Pencil layers </p>
	 * @see #__DNA__FIELD__gpencil_new_layer_col
	 */
	
	public void setGpencil_new_layer_col(CArrayFacade<Float> gpencil_new_layer_col) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 9788;
		} else {
			__dna__offset = 9732;
		}
		if (__io__equals(gpencil_new_layer_col, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, gpencil_new_layer_col)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, gpencil_new_layer_col);
		} else {
			__io__generic__copy( getGpencil_new_layer_col(), gpencil_new_layer_col);
		}
	}

	/**
	 * Get method for struct member 'tweak_threshold'.
	 * @see #__DNA__FIELD__tweak_threshold
	 */
	
	public short getTweak_threshold() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 9804);
		} else {
			return __io__block.readShort(__io__address + 9748);
		}
	}

	/**
	 * Set method for struct member 'tweak_threshold'.
	 * @see #__DNA__FIELD__tweak_threshold
	 */
	
	public void setTweak_threshold(short tweak_threshold) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 9804, tweak_threshold);
		} else {
			__io__block.writeShort(__io__address + 9748, tweak_threshold);
		}
	}

	/**
	 * Get method for struct member 'navigation_mode'.
	 * @see #__DNA__FIELD__navigation_mode
	 */
	
	public byte getNavigation_mode() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readByte(__io__address + 9806);
		} else {
			return __io__block.readByte(__io__address + 9750);
		}
	}

	/**
	 * Set method for struct member 'navigation_mode'.
	 * @see #__DNA__FIELD__navigation_mode
	 */
	
	public void setNavigation_mode(byte navigation_mode) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeByte(__io__address + 9806, navigation_mode);
		} else {
			__io__block.writeByte(__io__address + 9750, navigation_mode);
		}
	}

	/**
	 * Get method for struct member 'pad'.
	 * @see #__DNA__FIELD__pad
	 */
	
	public byte getPad() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readByte(__io__address + 9807);
		} else {
			return __io__block.readByte(__io__address + 9751);
		}
	}

	/**
	 * Set method for struct member 'pad'.
	 * @see #__DNA__FIELD__pad
	 */
	
	public void setPad(byte pad) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeByte(__io__address + 9807, pad);
		} else {
			__io__block.writeByte(__io__address + 9751, pad);
		}
	}

	/**
	 * Get method for struct member 'author'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> author name for file formats supporting it </p>
	 * @see #__DNA__FIELD__author
	 */
	
	public CArrayFacade<Byte> getAuthor() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
		int[] __dna__dimensions = new int[]{
			80
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Byte>(__io__address + 9808, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Byte>(__io__address + 9752, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'author'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> author name for file formats supporting it </p>
	 * @see #__DNA__FIELD__author
	 */
	
	public void setAuthor(CArrayFacade<Byte> author) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 9808;
		} else {
			__dna__offset = 9752;
		}
		if (__io__equals(author, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, author)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, author);
		} else {
			__io__generic__copy( getAuthor(), author);
		}
	}

	/**
	 * Get method for struct member 'font_path_ui'.
	 * @see #__DNA__FIELD__font_path_ui
	 */
	
	public CArrayFacade<Byte> getFont_path_ui() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
		int[] __dna__dimensions = new int[]{
			1024
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Byte>(__io__address + 9888, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Byte>(__io__address + 9832, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'font_path_ui'.
	 * @see #__DNA__FIELD__font_path_ui
	 */
	
	public void setFont_path_ui(CArrayFacade<Byte> font_path_ui) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 9888;
		} else {
			__dna__offset = 9832;
		}
		if (__io__equals(font_path_ui, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, font_path_ui)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, font_path_ui);
		} else {
			__io__generic__copy( getFont_path_ui(), font_path_ui);
		}
	}

	/**
	 * Get method for struct member 'font_path_ui_mono'.
	 * @see #__DNA__FIELD__font_path_ui_mono
	 */
	
	public CArrayFacade<Byte> getFont_path_ui_mono() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
		int[] __dna__dimensions = new int[]{
			1024
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Byte>(__io__address + 10912, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Byte>(__io__address + 10856, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'font_path_ui_mono'.
	 * @see #__DNA__FIELD__font_path_ui_mono
	 */
	
	public void setFont_path_ui_mono(CArrayFacade<Byte> font_path_ui_mono) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 10912;
		} else {
			__dna__offset = 10856;
		}
		if (__io__equals(font_path_ui_mono, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, font_path_ui_mono)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, font_path_ui_mono);
		} else {
			__io__generic__copy( getFont_path_ui_mono(), font_path_ui_mono);
		}
	}

	/**
	 * Get method for struct member 'compute_device_type'.
	 * @see #__DNA__FIELD__compute_device_type
	 */
	
	public int getCompute_device_type() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 11936);
		} else {
			return __io__block.readInt(__io__address + 11880);
		}
	}

	/**
	 * Set method for struct member 'compute_device_type'.
	 * @see #__DNA__FIELD__compute_device_type
	 */
	
	public void setCompute_device_type(int compute_device_type) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 11936, compute_device_type);
		} else {
			__io__block.writeInt(__io__address + 11880, compute_device_type);
		}
	}

	/**
	 * Get method for struct member 'compute_device_id'.
	 * @see #__DNA__FIELD__compute_device_id
	 */
	
	public int getCompute_device_id() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 11940);
		} else {
			return __io__block.readInt(__io__address + 11884);
		}
	}

	/**
	 * Set method for struct member 'compute_device_id'.
	 * @see #__DNA__FIELD__compute_device_id
	 */
	
	public void setCompute_device_id(int compute_device_id) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 11940, compute_device_id);
		} else {
			__io__block.writeInt(__io__address + 11884, compute_device_id);
		}
	}

	/**
	 * Get method for struct member 'fcu_inactive_alpha'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> opacity of inactive F-Curves in F-Curve Editor </p>
	 * @see #__DNA__FIELD__fcu_inactive_alpha
	 */
	
	public float getFcu_inactive_alpha() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readFloat(__io__address + 11944);
		} else {
			return __io__block.readFloat(__io__address + 11888);
		}
	}

	/**
	 * Set method for struct member 'fcu_inactive_alpha'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> opacity of inactive F-Curves in F-Curve Editor </p>
	 * @see #__DNA__FIELD__fcu_inactive_alpha
	 */
	
	public void setFcu_inactive_alpha(float fcu_inactive_alpha) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeFloat(__io__address + 11944, fcu_inactive_alpha);
		} else {
			__io__block.writeFloat(__io__address + 11888, fcu_inactive_alpha);
		}
	}

	/**
	 * Get method for struct member 'pixelsize'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> private, set by GHOST, to multiply DPI with </p>
	 * @see #__DNA__FIELD__pixelsize
	 */
	
	public float getPixelsize() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readFloat(__io__address + 11948);
		} else {
			return __io__block.readFloat(__io__address + 11892);
		}
	}

	/**
	 * Set method for struct member 'pixelsize'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> private, set by GHOST, to multiply DPI with </p>
	 * @see #__DNA__FIELD__pixelsize
	 */
	
	public void setPixelsize(float pixelsize) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeFloat(__io__address + 11948, pixelsize);
		} else {
			__io__block.writeFloat(__io__address + 11892, pixelsize);
		}
	}

	/**
	 * Get method for struct member 'virtual_pixel'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> virtual pixelsize mode </p>
	 * @see #__DNA__FIELD__virtual_pixel
	 */
	
	public int getVirtual_pixel() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readInt(__io__address + 11952);
		} else {
			return __io__block.readInt(__io__address + 11896);
		}
	}

	/**
	 * Set method for struct member 'virtual_pixel'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> virtual pixelsize mode </p>
	 * @see #__DNA__FIELD__virtual_pixel
	 */
	
	public void setVirtual_pixel(int virtual_pixel) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeInt(__io__address + 11952, virtual_pixel);
		} else {
			__io__block.writeInt(__io__address + 11896, virtual_pixel);
		}
	}

	/**
	 * Get method for struct member 'pie_interaction_type'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> if keeping a pie menu spawn button pressed after this time, it turns into a drag/release pie menu </p>
	 * @see #__DNA__FIELD__pie_interaction_type
	 */
	
	public short getPie_interaction_type() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 11956);
		} else {
			return __io__block.readShort(__io__address + 11900);
		}
	}

	/**
	 * Set method for struct member 'pie_interaction_type'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> if keeping a pie menu spawn button pressed after this time, it turns into a drag/release pie menu </p>
	 * @see #__DNA__FIELD__pie_interaction_type
	 */
	
	public void setPie_interaction_type(short pie_interaction_type) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 11956, pie_interaction_type);
		} else {
			__io__block.writeShort(__io__address + 11900, pie_interaction_type);
		}
	}

	/**
	 * Get method for struct member 'pie_initial_timeout'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> direction in the pie menu will always be calculated from the initial position within this time limit </p>
	 * @see #__DNA__FIELD__pie_initial_timeout
	 */
	
	public short getPie_initial_timeout() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 11958);
		} else {
			return __io__block.readShort(__io__address + 11902);
		}
	}

	/**
	 * Set method for struct member 'pie_initial_timeout'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> direction in the pie menu will always be calculated from the initial position within this time limit </p>
	 * @see #__DNA__FIELD__pie_initial_timeout
	 */
	
	public void setPie_initial_timeout(short pie_initial_timeout) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 11958, pie_initial_timeout);
		} else {
			__io__block.writeShort(__io__address + 11902, pie_initial_timeout);
		}
	}

	/**
	 * Get method for struct member 'pie_animation_timeout'.
	 * @see #__DNA__FIELD__pie_animation_timeout
	 */
	
	public short getPie_animation_timeout() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 11960);
		} else {
			return __io__block.readShort(__io__address + 11904);
		}
	}

	/**
	 * Set method for struct member 'pie_animation_timeout'.
	 * @see #__DNA__FIELD__pie_animation_timeout
	 */
	
	public void setPie_animation_timeout(short pie_animation_timeout) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 11960, pie_animation_timeout);
		} else {
			__io__block.writeShort(__io__address + 11904, pie_animation_timeout);
		}
	}

	/**
	 * Get method for struct member 'pie_menu_confirm'.
	 * @see #__DNA__FIELD__pie_menu_confirm
	 */
	
	public short getPie_menu_confirm() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 11962);
		} else {
			return __io__block.readShort(__io__address + 11906);
		}
	}

	/**
	 * Set method for struct member 'pie_menu_confirm'.
	 * @see #__DNA__FIELD__pie_menu_confirm
	 */
	
	public void setPie_menu_confirm(short pie_menu_confirm) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 11962, pie_menu_confirm);
		} else {
			__io__block.writeShort(__io__address + 11906, pie_menu_confirm);
		}
	}

	/**
	 * Get method for struct member 'pie_menu_radius'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> pie menu radius </p>
	 * @see #__DNA__FIELD__pie_menu_radius
	 */
	
	public short getPie_menu_radius() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 11964);
		} else {
			return __io__block.readShort(__io__address + 11908);
		}
	}

	/**
	 * Set method for struct member 'pie_menu_radius'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> pie menu radius </p>
	 * @see #__DNA__FIELD__pie_menu_radius
	 */
	
	public void setPie_menu_radius(short pie_menu_radius) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 11964, pie_menu_radius);
		} else {
			__io__block.writeShort(__io__address + 11908, pie_menu_radius);
		}
	}

	/**
	 * Get method for struct member 'pie_menu_threshold'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> pie menu distance from center before a direction is set </p>
	 * @see #__DNA__FIELD__pie_menu_threshold
	 */
	
	public short getPie_menu_threshold() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 11966);
		} else {
			return __io__block.readShort(__io__address + 11910);
		}
	}

	/**
	 * Set method for struct member 'pie_menu_threshold'.
	 * <h3>Field Documentation</h3>
	 * <h4>Blender Source Code:</h4>
	 * <p> pie menu distance from center before a direction is set </p>
	 * @see #__DNA__FIELD__pie_menu_threshold
	 */
	
	public void setPie_menu_threshold(short pie_menu_threshold) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 11966, pie_menu_threshold);
		} else {
			__io__block.writeShort(__io__address + 11910, pie_menu_threshold);
		}
	}

	/**
	 * Get method for struct member 'walk_navigation'.
	 * @see #__DNA__FIELD__walk_navigation
	 */
	
	public WalkNavigation getWalk_navigation() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return new WalkNavigation(__io__address + 11968, __io__block, __io__blockTable);
		} else {
			return new WalkNavigation(__io__address + 11912, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'walk_navigation'.
	 * @see #__DNA__FIELD__walk_navigation
	 */
	
	public void setWalk_navigation(WalkNavigation walk_navigation) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 11968;
		} else {
			__dna__offset = 11912;
		}
		if (__io__equals(walk_navigation, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, walk_navigation)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, walk_navigation);
		} else {
			__io__generic__copy( getWalk_navigation(), walk_navigation);
		}
	}

	/**
	 * Get method for struct member 'opensubdiv_compute_type'.
	 * @see #__DNA__FIELD__opensubdiv_compute_type
	 */
	
	public short getOpensubdiv_compute_type() throws IOException
	{
		if ((__io__pointersize == 8)) {
			return __io__block.readShort(__io__address + 12000);
		} else {
			return __io__block.readShort(__io__address + 11944);
		}
	}

	/**
	 * Set method for struct member 'opensubdiv_compute_type'.
	 * @see #__DNA__FIELD__opensubdiv_compute_type
	 */
	
	public void setOpensubdiv_compute_type(short opensubdiv_compute_type) throws IOException
	{
		if ((__io__pointersize == 8)) {
			__io__block.writeShort(__io__address + 12000, opensubdiv_compute_type);
		} else {
			__io__block.writeShort(__io__address + 11944, opensubdiv_compute_type);
		}
	}

	/**
	 * Get method for struct member 'pad5'.
	 * @see #__DNA__FIELD__pad5
	 */
	
	public CArrayFacade<Byte> getPad5() throws IOException
	{
		Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
		int[] __dna__dimensions = new int[]{
			6
		};
		if ((__io__pointersize == 8)) {
			return new CArrayFacade<Byte>(__io__address + 12002, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		} else {
			return new CArrayFacade<Byte>(__io__address + 11946, __dna__targetTypes, __dna__dimensions, __io__block, __io__blockTable);
		}
	}

	/**
	 * Set method for struct member 'pad5'.
	 * @see #__DNA__FIELD__pad5
	 */
	
	public void setPad5(CArrayFacade<Byte> pad5) throws IOException
	{
		long __dna__offset;
		if ((__io__pointersize == 8)) {
			__dna__offset = 12002;
		} else {
			__dna__offset = 11946;
		}
		if (__io__equals(pad5, __io__address + __dna__offset)) {
			return;
		} else if (__io__same__encoding(this, pad5)) {
			__io__native__copy(__io__block, __io__address + __dna__offset, pad5);
		} else {
			__io__generic__copy( getPad5(), pad5);
		}
	}

	/**
	 * Instantiates a pointer on this instance.
	 */
	public CPointer<UserDef> __io__addressof() {
		return new CPointer<UserDef>(__io__address, new Class[]{UserDef.class}, __io__block, __io__blockTable);
	}

}