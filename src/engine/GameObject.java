package engine;

import java.util.ArrayList;
import java.util.List;

import dataStructure.Transform;

public class GameObject {

	private List<Component> components;
	private String name;

	public Transform transform;

	public GameObject(String name, Transform transform) {
		this.name = name;
		this.transform = transform;

		this.components = new ArrayList<Component>();
	}

	public void addComponents(Component component) {
		this.components.add(component);
	}
	
	public void update(double delta) {
		for (Component component : components) {
			component.update(delta);
		}
	}

	public <T extends Component> T getComponent(Class<T> componentClass) {
		for (Component component : components) {
			if (componentClass.isAssignableFrom(component.getClass())) {
				try {
					return componentClass.cast(component);
				} catch (ClassCastException e) {
					e.printStackTrace();
					System.exit(-1);
				}
			}
		}
		return null;
	}
}
