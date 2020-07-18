package org.cakelab.blender.utils;

import java.io.IOException;
import java.util.Iterator;

import org.blender.dna.bNode;
import org.blender.dna.bNodeSocket;
import org.blender.dna.bNodeSocketValueRGBA;
import org.blender.dna.constants.node_type.SocketType;
import org.cakelab.blender.nio.CArrayFacade;

/**
 * Helper class for node traversal and property access
 * 
 * <h4>Brief intro to nodes:</h4>
 * Receive nodetree from Material
 * <pre>
 *   Material m = ...;
 *   bNodeTree nodetree = m.getNodetree().get();
 * </pre>
 * Retrieve list of nodes from tree:
 * <pre>
 *   ListBase nodes = tree.getNodes();
 *   Iterator<bNode> it = BlenderListIterator.create(nodes.getFirst().cast(bNode.class));
 * </pre>
 * The list is not ordered.
 * 
 * Each node has a type (node.getType()) which corresponds to one in
 * {@link BKE_node}.
 * Each node in the list has input and output sockets.
 * Sockets have an identifier (string), a direction (in/out) 
 * and a default value. There are common socket identifiers, such as 
 * "Base Color" or "Emission" but also specific ones for certain 
 * node types.
 * 
 * Sockets may be connected to each other (output->input) via 
 * {@link bNodeLink}s feeding the value of the output socket into the 
 * input socket.
 * 
 * Input and output sockets have a default value, which will be used
 * if there is no connecting input link overriding it.
 * The default value, can be customised in Blender's GUI (node view, 
 * or material view). Examples for default values, usually customised, 
 * are the name of a texture file, or the base colour of a surface 
 * shader.
 * 
 * The value of a socket has a specific data type corresponding to {@link SocketType.Type}, 
 * such as string, boolean, integer, or a four element vector with float type components 
 * to represent RGBA-values.
 * To retrieve the default value of a socket, the type of the value must 
 * be known.
 * <pre>
 *    bNodeSocketValueRGBA default_value = socket.getDefault_value().cast(bNodeSocketValueRGBA.class).get();
 * </pre>
 * 
 * 
 * @author homac
 *
 */
public class Nodes {

	public static bNodeSocket findInputSocket(bNode node, String identifier) throws IOException {
		Iterator<bNodeSocket> sockets = BlenderListIterator.create(node.getInputs(), bNodeSocket.class);
		while (sockets.hasNext()) {
			bNodeSocket socket = sockets.next();
			String socketId = socket.getIdentifier().asString();
			if (identifier.equals(socketId)) {
				return socket;
			}
		}
		return null;
	}
	public static bNodeSocket findOutputSocket(bNode node, String identifier) throws IOException {
		Iterator<bNodeSocket> sockets = BlenderListIterator.create(node.getOutputs(), bNodeSocket.class);
		while (sockets.hasNext()) {
			bNodeSocket socket = sockets.next();
			if (identifier.equals(socket.getIdentifier().asString())) {
				return socket;
			}
		}
		return null;
	}
	public static CArrayFacade<Float> getDefaultRGBAInput(bNode node, String identifier) throws IOException {
		bNodeSocket socket = findInputSocket(node, identifier);
		bNodeSocketValueRGBA default_value = socket.getDefault_value().cast(bNodeSocketValueRGBA.class).get();
		return default_value != null ? default_value.getValue() : null;
	}
	


}
