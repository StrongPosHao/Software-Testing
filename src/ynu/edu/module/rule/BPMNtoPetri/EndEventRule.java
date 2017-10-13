package ynu.edu.module.rule.BPMNtoPetri;

import java.util.Hashtable;
import java.util.LinkedList;

import ynu.edu.data.Graphics;
import ynu.edu.module.petri.*;
import ynu.edu.module.bpmn.*;

public class EndEventRule extends AbstractRule {

	@Override
	public boolean matches(Graphics<BpmnElement> graphics) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected LinkedList<String> split(Graphics<BpmnElement> graphics) {
		Hashtable<String, LinkedList<String>> bpmn_nodes = graphics.getIds();
		LinkedList<String> endevent_nodes = bpmn_nodes.get(EndEvent.class.getName());
		return endevent_nodes;
	}

	@Override
	public Graphics<PetriElement> transfer(Graphics<BpmnElement> graphics) {
		Graphics<PetriElement> g_petri = new Graphics<PetriElement>();
		LinkedList<String> endevent_nodes = split(graphics);
		for (String node : endevent_nodes) {
			Transition trans = new Transition("trans" + trans_id++);
			Arc arc = new Arc("arc" + arc_id++);
			Place place = new Place("p" + place_id++);
			g_petri.addLink(trans.getId(), arc.getId());
			g_petri.addLink(arc.getId(), place.getId());
		}
		return g_petri;
	}
	
}
