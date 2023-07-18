package com.capibaracode.backend.domain.entities;

import com.capibaracode.backend.util.enums.InvoiceStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String invoiceNumber;
    private String keyAccess;
    private InvoiceStatus status;
    private LocalDate issueDate;
    private String description;
    private Double iva;
    private BigDecimal subtotalExcludingIVA;
    private BigDecimal total;
    private BigDecimal discount;

    @ManyToOne
    private User user;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Payment payment;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<InvoiceDetail> details = new ArrayList<>();

    public void addDetail(InvoiceDetail detail){
        this.details.add(detail);
    }
}
