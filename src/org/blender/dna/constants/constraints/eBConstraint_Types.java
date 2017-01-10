package org.blender.dna.constants.constraints;

public enum eBConstraint_Types {
	CONSTRAINT_TYPE_NULL(0),			/* Invalid/legacy constraint */
	CONSTRAINT_TYPE_CHILDOF(1),			/* Unimplemented non longer :) - during constraints recode, Aligorith */
	CONSTRAINT_TYPE_TRACKTO(2),
	CONSTRAINT_TYPE_KINEMATIC(3),
	CONSTRAINT_TYPE_FOLLOWPATH(4),
	CONSTRAINT_TYPE_ROTLIMIT(5),			/* Unimplemented no longer :) - Aligorith */
	CONSTRAINT_TYPE_LOCLIMIT(6),			/* Unimplemented no longer :) - Aligorith */
	CONSTRAINT_TYPE_SIZELIMIT(7),			/* Unimplemented no longer :) - Aligorith */
	CONSTRAINT_TYPE_ROTLIKE(8),
	CONSTRAINT_TYPE_LOCLIKE(9),
	CONSTRAINT_TYPE_SIZELIKE(10),
	CONSTRAINT_TYPE_PYTHON(11),				/* Unimplemented no longer :) - Aligorith. Scripts */
	CONSTRAINT_TYPE_ACTION(12),
	CONSTRAINT_TYPE_LOCKTRACK(13),			/* New Tracking constraint that locks an axis in place - theeth */
	CONSTRAINT_TYPE_DISTLIMIT(14),			/* limit distance */
	CONSTRAINT_TYPE_STRETCHTO(15),			/* claiming this to be mine :) is in tuhopuu bjornmose */ 
	CONSTRAINT_TYPE_MINMAX(16),  			/* floor constraint */
	CONSTRAINT_TYPE_RIGIDBODYJOINT(17),		/* rigidbody constraint */
	CONSTRAINT_TYPE_CLAMPTO(18), 			/* clampto constraint */
	CONSTRAINT_TYPE_TRANSFORM(19),			/* transformation (loc/rot/size -> loc/rot/size) constraint */
	CONSTRAINT_TYPE_SHRINKWRAP(20),		/* shrinkwrap (loc/rot) constraint */
	CONSTRAINT_TYPE_DAMPTRACK(21),			/* New Tracking constraint that minimizes twisting */
	CONSTRAINT_TYPE_SPLINEIK(22),			/* Spline-IK - Align 'n' bones to a curve */
	CONSTRAINT_TYPE_TRANSLIKE(23),			/* Copy transform matrix */
	CONSTRAINT_TYPE_SAMEVOL(24),			/* Maintain volume during scaling */
	CONSTRAINT_TYPE_PIVOT(25),			/* Pivot Constraint */
	CONSTRAINT_TYPE_FOLLOWTRACK(26),		/* Follow Track Constraint */
	CONSTRAINT_TYPE_CAMERASOLVER(27),		/* Camera Solver Constraint */
	CONSTRAINT_TYPE_OBJECTSOLVER(28),		/* Object Solver Constraint */
	CONSTRAINT_TYPE_TRANSFORM_CACHE(29);	
	/* Transform Cache Constraint */
	
	/** const value of the enum (not necessarily the ordinate) */
	public final int v;

	eBConstraint_Types(int v) {
		this.v = v;
	}
	
}