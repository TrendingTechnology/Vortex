package com.yazan98.river.web.extras.swagger

import org.springframework.context.annotation.Bean
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.VendorExtension
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


/**
 *    Copyright [2019] [Yazan Tarifi]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/**
 * Created By : Yazan Tarifi
 * Date : 5/17/2019
 * Time : 12:27 PM
 */

abstract class RiverSwaggerNormalConfiguration : SwaggerConfig {

    @Bean
    override fun ProvideSwaggerConfiguration(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(
                ApiInfo(
                    getSwaggerDetails().title,
                    getSwaggerDetails().description,
                    getSwaggerDetails().version,
                    getSwaggerDetails().termsOfServiceUrl,
                    getSwaggerDetails().contact,
                    getSwaggerDetails().license,
                    getSwaggerDetails().licenseUrl,
                    getSwaggerDetails().vendorExtensions as MutableCollection<VendorExtension<Any>>
                )
            )
    }

}