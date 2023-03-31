package com.rean.config;

import com.rean.model.Province;
import com.rean.repository.ProvinceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Configuration
public class LoadProvinceData {

    private final ProvinceRepository provinceRepository;

    public LoadProvinceData(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @PostConstruct
    void loadProvinces() {
        StopWatch watch = new StopWatch();
        watch.start();
        provinceRepository.saveAll(this.provinces);
        watch.stop();
        log.info("Load provinces {} time Elapsed: {}", this.provinces.size(), watch.getTotalTimeSeconds());
    }

    List<Province> provinces = Arrays.asList(
            new Province(0L, "01", "បន្ទាយមានជ័យ", "Banteay Meanchey"),
            new Province(0L, "02", "បាត់ដំបង", "Battambang"),
            new Province(0L, "03", "កំពង់ចាម", "Kampong Cham"),
            new Province(0L, "04", "កំពង់ឆ្នាំង", "Kampong Chhnang"),
            new Province(0L, "05", "កំពង់ស្ពឺ", "Kampong Speu"),
            new Province(0L, "06", "កំពង់ធំ", "Kampong Thom"),
            new Province(0L, "07", "កំពត	", "Kampot"),
            new Province(0L, "08", "កណ្ដាល", "Kandal"),
            new Province(0L, "09", "កោះកុង", "Koh Kong"),
            new Province(0L, "10", "ក្រចេះ", "Kratie"),
            new Province(0L, "11", "មណ្ឌលគិរី", "Mondul Kiri"),
            new Province(0L, "12", "ភ្នំពេញ", "Phnom Penh"),
            new Province(0L, "13", "ព្រះវិហារ", "Preah Vihear"),
            new Province(0L, "14", "ព្រៃវែង", "Prey Veng"),
            new Province(0L, "15", "ពោធិ៍សាត់", "Pursat"),
            new Province(0L, "16", "រតនគិរី", "Ratanak Kiri"),
            new Province(0L, "17", "សៀមរាប", "Siemreap"),
            new Province(0L, "18", "ព្រះសីហនុ", "Preah Sihanouk"),
            new Province(0L, "19", "ស្ទឹងត្រែង", "Stung Treng"),
            new Province(0L, "20", "ស្វាយរៀង", "Svay Rieng"),
            new Province(0L, "21", "តាកែវ", "Takeo"),
            new Province(0L, "22", "ឧត្ដរមានជ័យ", "Oddar Meanchey"),
            new Province(0L, "23", "កែប", "Kep"),
            new Province(0L, "24", "ប៉ៃលិន", "Pailin"),
            new Province(0L, "25", "ត្បូងឃ្មុំ", "Tboung Khmum")
    );


}
