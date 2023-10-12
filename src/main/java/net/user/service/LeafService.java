package net.user.service;

import java.util.List;
import net.user.entity.Leaf;

public interface LeafService {
	
    List<Leaf> getAllLeafs();
    
    Leaf checkLeaf(byte[] b) throws Exception ;
    
}
