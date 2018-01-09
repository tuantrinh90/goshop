package com.goshop.app.data.realm;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;

/**
 * Created by yahyamukhlis on 4/17/17.
 */

@SuppressWarnings("ALL")
public class SchemaMigration implements RealmMigration {

    public static final long SCHEMA_VERSION = 1;

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

    }
}
