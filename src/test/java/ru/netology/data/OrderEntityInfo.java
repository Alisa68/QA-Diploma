package ru.netology.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OrderEntityInfo {
    private String id;
    private String created;
    private String credit_id;
    private String payment_id;
}
