package org.cakelab.blender.io.convert.mesh;

import java.io.IOException;

import org.blender.dna.CustomData;
import org.blender.dna.CustomDataLayer;
import org.blender.dna.MLoop;
import org.blender.dna.MLoopUV;
import org.blender.dna.MPoly;
import org.blender.dna.MVert;
import org.blender.dna.Mesh;
import org.cakelab.blender.nio.CPointer;

public interface CustomDataHelper {
	// these constants are defined in DNA_customdata_types.h
	static final int CD_MVERT = 0;
	static final int CD_MLOOPUV = 16;
	static final int CD_MPOLY = 25;
	static final int CD_MLOOP = 26;

	static MLoopUV[] getLoopUv(Mesh mesh) throws IOException {
		CustomDataLayer layer = getLayer(mesh.getLdata(), CD_MLOOPUV);
		CPointer<MLoopUV> pointer = layer.getData().cast(MLoopUV.class);
		return pointer.toArray(mesh.getTotloop());
	}

	static MVert[] getMvert(Mesh mesh) throws IOException {
		CustomDataLayer layer = getLayer(mesh.getVdata(), CD_MVERT);
		CPointer<MVert> pointer = layer.getData().cast(MVert.class);
		return pointer.toArray(mesh.getTotvert());
	}

	static MPoly[] getMPoly(Mesh mesh) throws IOException {
		CustomDataLayer layer = getLayer(mesh.getPdata(), CD_MPOLY);
		CPointer<MPoly> pointer = layer.getData().cast(MPoly.class);
		return pointer.toArray(mesh.getTotpoly());
	}

	static MLoop[] getMloop(Mesh mesh) throws IOException {
		CustomDataLayer layer = getLayer(mesh.getLdata(), CD_MLOOP);
		CPointer<MLoop> pointer = layer.getData().cast(MLoop.class);
		return pointer.toArray(mesh.getTotloop());
	}

	static CustomDataLayer getLayer(CustomData ldata, int type) throws IOException {
		for (CustomDataLayer l : ldata.getLayers().toArray(ldata.getTotlayer())) {
			if (l.getType() == type) {
				return l;
			}
		}
		return null;
	}

}
