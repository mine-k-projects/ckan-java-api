package minek.ckan.v3.datastore.model.enums;

// NOTE : insert 나 update 시에는 key 가 필요하다.
// https://github.com/ckan/ckan/blob/master/ckanext/datastore/backend/postgres.py#L1073
public enum Method {
    upsert, insert, update
}
