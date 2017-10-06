/**
 * 
 */
package com.hostme.service.interfac;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hostme.entities.Ad;

/**
 * @author rmidi
 *
 */
public interface AdService {
	Ad findAdById(Long id);
	List<Ad> findAdsByLocation(String location);
	void saveAd(Ad ad);
    void updateAd(Ad ad);
    void deleteAdById(Long id);
    List<Ad> getMyAds();
    List<Ad> getAdsByPropertyLocation(String location);
    Page<Ad> getAllAds(int forPage, int withPageSize);
    public long getAllCount();
}
