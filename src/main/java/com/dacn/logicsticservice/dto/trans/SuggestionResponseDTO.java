package com.dacn.logicsticservice.dto.trans;

import java.util.List;

public class SuggestionResponseDTO {
    private long totalAmount;
    private List<SuggestionDetailDTO> suggestionDetailDTOS;

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<SuggestionDetailDTO> getSuggestionDetailDTOS() {
        return suggestionDetailDTOS;
    }

    public void setSuggestionDetailDTOS(List<SuggestionDetailDTO> suggestionDetailDTOS) {
        this.suggestionDetailDTOS = suggestionDetailDTOS;
    }
}
