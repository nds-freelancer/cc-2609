package net.user.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import net.user.entity.Cake;
import net.user.entity.User;
import net.user.repository.CakeRepository;
import net.user.service.CakeService;

@Service
@AllArgsConstructor
public class CakeServiceImpl implements CakeService {

    private CakeRepository cakeRepository;

    @Override
    public List<Cake> getAllCakes() {
        return cakeRepository.findAll();
    }
    
	@Override
	public Cake updateCake(Cake cake) {
		System.out.println("cakeRepository:"+cakeRepository+cake.getCakeid()+":"+cake.getCakename());
		Cake updatedCake = cakeRepository.saveAndFlush(cake);
        return updatedCake;
	}

}
