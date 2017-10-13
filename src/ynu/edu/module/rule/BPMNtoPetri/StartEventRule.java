package ynu.edu.module.rule.BPMNtoPetri;

import java.util.Hashtable;
import java.util.LinkedList;

import ynu.edu.data.Graphics;
import ynu.edu.module.bpmn.BpmnElement;
import ynu.edu.module.bpmn.StartEvent;
import ynu.edu.module.petri.*;


public class StartEventRule extends AbstractRule {
	
	public boolean matches(Graphics<BpmnElement> graphics) {
		
		return true;
		
	}
	
	@Override
	protected LinkedList<String> split(Graphics<BpmnElement> graphics) {
		Hashtable<String, LinkedList<String>> bpmn_nodes = graphics.getIds();
		LinkedList<String> startevent_nodes = bpmn_nodes.get(StartEvent.class.getName());
		return startevent_nodes;
	}

	@Override
	public Graphics<PetriElement> transfer(Graphics<BpmnElement> graphics) {
		Graphics<PetriElement> g_petri = new Graphics<PetriElement>();
		LinkedList<String> startevent_nodes = split(graphics);
		for (String node : startevent_nodes) {
			Place place = new Place("p" + place_id++);
			Arc arc = new Arc("arc" + arc_id);
			Transition trans = new Transition("trans" + trans_id++);
			g_petri.addNode(place);
			g_petri.addNode(arc);
			g_petri.addLink(place.getId(), arc.getId());
			g_petri.addNode(trans);
			g_petri.addLink(arc.getId(), trans.getId());
		}
		return g_petri;
	}
	
	public PetriElement tran(StartEvent s, Graphics<PetriElement> g_petri) {
		
		return null;
	}

}
