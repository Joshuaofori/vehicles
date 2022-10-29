package com.udacity.pricing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.udacity.pricing.api.PricingController;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
public class PriceControllerUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPrices() throws Exception {
        Long vehicleId = 1L;
        mockMvc.perform(get("/services/price?vehicleId=" + vehicleId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currency").value("USD"))
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.vehicleId").value(1));
    }
}
