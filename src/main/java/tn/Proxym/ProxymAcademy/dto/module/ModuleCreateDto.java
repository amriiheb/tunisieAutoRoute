package tn.Proxym.ProxymAcademy.dto.module;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.Proxym.ProxymAcademy.model.Training;

@Getter
@Setter
@NoArgsConstructor
public class ModuleCreateDto {
private String name ;
private String description ;
private int number ;
private Training training ;
}
