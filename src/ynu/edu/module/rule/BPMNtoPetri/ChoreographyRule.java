package ynu.edu.module.rule.BPMNtoPetri;

import java.util.Hashtable;
import java.util.LinkedList;

import ynu.edu.data.Graphics;
import ynu.edu.module.petri.*;
import ynu.edu.module.bpmn.*;;

public class ChoreographyRule extends AbstractRule{

	@Override
	public boolean matches(Graphics<BpmnElement> graphics) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected LinkedList<String> split(Graphics<BpmnElement> graphics) {
		Hashtable<String, LinkedList<String>> bpmn_nodes = graphics.getIds();
		LinkedList<String> Choreography_nodes = bpmn_nodes.get(Choreography.class.getName());
		return Choreography_nodes;
	}

	@Override
	public Graphics<PetriElement> transfer(Graphics<BpmnElement> graphics) {
		Graphics<PetriElement> g_petri = new Graphics<>();
		LinkedList<String> Choreography_nodes = split(graphics);
		for (String node : Choreography_nodes) {
			Choreography chore = (Choreography) graphics.getNodeData(node);
			String incoming = chore.getInComing();
			String outcoming = chore.getOutGoing();
			String name = chore.getName();
			Transition trans = new Transition(incoming + '_' + outcoming + '_' + name + trans_id++);
			g_petri.addNode(trans);
		}
		return g_petri;
	}
	
}
