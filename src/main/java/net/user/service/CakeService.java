package net.user.service;

import java.util.List;
import net.user.entity.Cake;

public interface CakeService {
	
    List<Cake> getAllCakes();
    
	public Cake updateCake(Cake cake);
	
}
