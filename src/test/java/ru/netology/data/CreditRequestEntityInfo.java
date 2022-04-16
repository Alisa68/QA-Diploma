package ru.netology.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreditRequestEntityInfo {
    private String id;
    private String bank_id;
    private String created;
    private String status;
}
