package ynu.edu.module.rule.BPMNtoPetri;

import java.util.Hashtable;
import java.util.LinkedList;

import ynu.edu.data.Graphics;
import ynu.edu.module.petri.*;
import ynu.edu.module.bpmn.*;

public class SequenceFlowRule extends AbstractRule {

	@Override
	public boolean matches(Graphics<BpmnElement> graphics) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected LinkedList<String> split(Graphics<BpmnElement> graphics) {
		Hashtable<String, LinkedList<String>> bpmn_nodes = graphics.getIds();
		LinkedList<String> sequenceflow_nodes = bpmn_nodes.get(SequenceFlow.class.getName());
		return sequenceflow_nodes;
	}

	@Override
	public Graphics<PetriElement> transfer(Graphics<BpmnElement> graphics) {
		Graphics<PetriElement> g_petri = new Graphics<>();
		LinkedList<String> sequenceflow_nodes = split(graphics);
		for (String node : sequenceflow_nodes) {
			Arc arc1 = new Arc("arc" + arc_id++);
			Arc arc2 = new Arc("arc" + arc_id++);
			Place place = new Place("p" + place_id++);
			g_petri.addNode(arc1);
			g_petri.addNode(place);
			g_petri.addLink(graphics.getIDbyNode(node)[0][0], arc1.getId());  //建立前一个结点与arc1的联系
			g_petri.addLink(arc1.getId(), place.getId());
			g_petri.addLink(place.getId(), arc2.getId());
			g_petri.addLink(arc2.getId(), graphics.getIDbyNode(node)[1][0]);
		}
		return g_petri;
	}
	

}
