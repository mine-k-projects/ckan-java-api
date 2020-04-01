package minek.ckan.v3.model.enums;

import lombok.Getter;

// config_option_update 에서만 사용
public enum GlobalConfigOption implements EnumCode {

    ckan_site_title("ckan_site_title"),
    ckan_site_logo("ckan.site_logo"),
    ckan_site_url("ckan.site_url"),
    ckan_site_description("ckan.site_description"),
    ckan_site_about("ckan.site_about"),
    ckan_site_intro_text("ckan.site_intro_text"),
    ckan_site_custom_css("ckan.site_custom_css"),
    ckan_favicon("ckan.favicon"),
    ckan_template_head_end("ckan.template_head_end"),
    ckan_template_footer_end("ckan.template_footer_end"),
    ckan_site_id("ckan.site_id"),
    ckan_recaptcha_publickey("ckan.recaptcha.publickey"),
    ckan_template_title_delimiter("ckan.template_title_delimiter"),
    //    ckan_template_head_end("ckan.template_head_end"),
    //    ckan_template_footer_end("ckan.template_footer_end"),
    ckan_dumps_url("ckan.dumps_url"),
    ckan_dumps_format("ckan.dumps_format"),
    ckan_homepage_style("ckan.homepage_style"),

    // # split string
    search_facets("search.facets"),
    package_hide_extras("package_hide_extras"),
    ckan_plugins("ckan.plugins"),

    // # bool
    debug("debug"),
    ckan_debug_supress_header("ckan.debug_supress_header"),
    ckan_legacy_templates("ckan.legacy_templates"),
    ckan_tracking_enabled("ckan.tracking_enabled"),

    // # int
    ckan_datasets_per_page("ckan.datasets_per_page"),
    ckan_activity_list_limit("ckan.activity_list_limit"),
    ckan_user_list_limit("ckan.user_list_limit"),
    search_facets_default("search.facets.default");

    @Getter
    private String code;

    GlobalConfigOption(String code) {
        this.code = code;
    }

}