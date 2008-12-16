package org.citygml4j.model.xal;

import java.util.List;

public interface PostTown extends XALBase {
	public List<AddressLine> getAddressLine();
	public List<PostTownName> getPostTownName();
	public PostTownSuffix getPostTownSuffix();
	public String getType();
	public boolean isSetAddressLine();
	public boolean isSetPostTownName();
	public boolean isSetPostTownSuffix();
	public boolean isSetType();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addPostTownName(PostTownName postTownName);
	public void setPostTownName(List<PostTownName> postTownName);
	public void setPostTownSuffix(PostTownSuffix postTownSuffix);
	public void setType(String type);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetPostTownName();
	public boolean unsetPostTownName(PostTownName postTownName);
	public void unsetPostTownSuffix();
	public void unsetType();
}
