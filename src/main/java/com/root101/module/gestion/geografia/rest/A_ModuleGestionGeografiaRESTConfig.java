/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.gestion.geografia.rest;

import com.root101.module.gestion.geografia.core.module.GeografiaCoreModule;
import com.root101.module.gestion.geografia.core.usecase_def.MunicipioUseCase;
import com.root101.module.gestion.geografia.repo.module.GeografiaRepoModule;
import com.root101.module.gestion.geografia.service.ResourceServiceServerImplementation;
import org.springframework.stereotype.Component;
import com.root101.module.gestion.geografia.service.ResourceServiceImplementation;
import com.root101.module.gestion.geografia.core.usecase_def.ProvinciaUseCase;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Component
public class A_ModuleGestionGeografiaRESTConfig {

    public static final String BASE_PACKAGE = "com.root101.module.gestion.geografia.rest";

    public final static MunicipioUseCase municipioUC;
    public final static ProvinciaUseCase provinciaUC;

    static {
        ResourceServiceImplementation.init();//creo el resource general
        ResourceServiceServerImplementation.init();//creo el resource general

        GeografiaCoreModule.init(GeografiaRepoModule.init());

        municipioUC = GeografiaCoreModule.getInstance().getImplementation(MunicipioUseCase.class);
        provinciaUC = GeografiaCoreModule.getInstance().getImplementation(ProvinciaUseCase.class);
    }
}
