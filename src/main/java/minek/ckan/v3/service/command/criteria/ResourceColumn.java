package minek.ckan.v3.service.command.criteria;

// https://github.com/ckan/ckan/blob/fcb38ba903b2c2b51b8620bd24571b284a86a2d6/ckan/model/resource.py#L25
// https://github.com/ckan/ckan/blob/fcb38ba903b2c2b51b8620bd24571b284a86a2d6/ckan/model/resource.py#L118
public enum ResourceColumn {
    url,
    format,
    description,
    hash,
    name,
    resource_type,
    mimetype,
    mimetype_inner,
    size,
    created,
    last_modified,
    metadata_modified,
    cache_url,
    cache_last_updated,
    url_type
}