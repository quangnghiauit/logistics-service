package com.dacn.logicsticservice.dto.trans;

import java.util.List;

public class OrderDetailResponse {
    private OrderDTO order;
    private List<SuggestionDetailDTO> orderDetails;

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public List<SuggestionDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<SuggestionDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
