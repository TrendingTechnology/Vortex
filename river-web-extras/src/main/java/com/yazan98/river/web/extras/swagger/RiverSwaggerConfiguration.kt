package com.yazan98.river.web.extras.swagger

import org.springframework.context.annotation.Bean
import springfox.documentation.builders.ParameterBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.schema.ModelRef
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Parameter
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
 * Time : 2:29 PM
 */

abstract class RiverSwaggerConfiguration : SwaggerConfig {

    private lateinit var authParam: ParameterBuilder
    private lateinit var languageParam: ParameterBuilder
    private lateinit var platformParam: ParameterBuilder
    private var paramsList: ArrayList<Parameter> = ArrayList(1)

    @Bean
    override fun ProvideSwaggerConfiguration(): Docket {
        buildAuthParam()
        buildLanguageParam()
        buildPlatformParam()
        addParams()
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .globalOperationParameters(paramsList)
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

    private fun buildAuthParam() {
        this.authParam = ParameterBuilder()
        authParam
            .name("Authorization")
            .modelRef(ModelRef("string"))
            .parameterType("header")
            .defaultValue("Bearer Token")
            .required(false)
            .build()
    }

    private fun buildLanguageParam() {
        this.languageParam = ParameterBuilder()
        languageParam
            .name("Accept-Language")
            .modelRef(ModelRef("string"))
            .parameterType("header")
            .defaultValue("en")
            .required(false)
            .build()
    }

    private fun buildPlatformParam() {
        this.platformParam = ParameterBuilder()
        platformParam
            .name("Platform")
            .modelRef(ModelRef("string"))
            .parameterType("header")
            .defaultValue("mobile")
            .required(false)
            .build()
    }

    private fun addParams() {
        paramsList.add(authParam.build())
        paramsList.add(languageParam.build())
        paramsList.add(platformParam.build())
    }

}
