package edu.cqun.eshop.service;

import java.util.List;

import edu.cqun.eshop.Iservice.ICarriageManagerService;
import edu.cqun.eshop.domain.Commodity;

public class CarriageManagerservice implements ICarriageManagerService {


	@Override
	public boolean addCommodity(Long userId, Commodity commodity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
<<<<<<< HEAD
	public boolean removeCommodity(Long userId, long commodityId) {
=======
	public boolean addCommodity(Long userId, Commodity commodity) {
>>>>>>> d565514c97f50fe9aba3ee71ccf6606d5a00771c
		// TODO Auto-generated method stub
		return false;
	}

	@Override
<<<<<<< HEAD
	public boolean removeCommodities(Long userId, List<Long> commodityIds) {
=======
	public boolean removeCommodity(Long userId, long commodityId) {
>>>>>>> d565514c97f50fe9aba3ee71ccf6606d5a00771c
		// TODO Auto-generated method stub
		return false;
	}

	@Override
<<<<<<< HEAD
	public boolean checkCarriage(Long userId) {
=======
	public boolean removeCommodities(Long userId, List<Long> commodityIds) {
>>>>>>> d565514c97f50fe9aba3ee71ccf6606d5a00771c
		// TODO Auto-generated method stub
		return false;
	}

	@Override
<<<<<<< HEAD
=======
	public boolean checkCarriage(Long userId) {

		// TODO Auto-generated method stub
		return false;
	}

	@Override
>>>>>>> d565514c97f50fe9aba3ee71ccf6606d5a00771c
	public boolean pay(Long userId, List<Long> commodityIds) {
		// TODO Auto-generated method stub
		return false;
	}

}
