package cn.mldn.resource.util;
import java.util.List;
import org.springframework.core.io.Resource;

public class ResourceBean {
	private List<Resource> resource;

	public List<Resource> getResource() {
		return resource;
	}

	public void setResource(List<Resource> resource) {
		this.resource = resource;
	}

}
