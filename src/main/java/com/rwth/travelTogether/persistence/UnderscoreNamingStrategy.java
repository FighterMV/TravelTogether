package com.rwth.travelTogether.persistence;

import org.hibernate.cfg.DefaultNamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnderscoreNamingStrategy extends DefaultNamingStrategy {

	private static Logger LOGGER = LoggerFactory.getLogger(UnderscoreNamingStrategy.class);

	public UnderscoreNamingStrategy() {

		super();
		LOGGER.info("initializing UnderscoreNamingStrategy");
	}

	@Override
	public String classToTableName(String className) {

		return super.classToTableName(className) + "_";
	}

	@Override
	public String columnName(String columnName) {

		return super.columnName(columnName);
	}

	@Override
	public String collectionTableName(String ownerEntity, String ownerEntityTable, String associatedEntity, String associatedEntityTable, String propertyName) {

		return super.collectionTableName(ownerEntity, ownerEntityTable, associatedEntity, associatedEntityTable, propertyName) + "_";
	}

	@Override
	public String foreignKeyColumnName(String propertyName, String propertyEntityName, String propertyTableName, String referencedColumnName) {

		return super.foreignKeyColumnName(propertyName, propertyEntityName, propertyTableName, referencedColumnName) + "_";
	}

	@Override
	public String joinKeyColumnName(String joinedColumn, String joinedTable) {

		return super.joinKeyColumnName(joinedColumn, joinedTable) + "_";
	}

	@Override
	public String logicalCollectionColumnName(String columnName, String propertyName, String referencedColumn) {

		return super.logicalCollectionColumnName(columnName, propertyName, referencedColumn);
	}

	@Override
	public String logicalCollectionTableName(String tableName, String ownerEntityTable, String associatedEntityTable, String propertyName) {

		return super.logicalCollectionTableName(tableName, ownerEntityTable, associatedEntityTable, propertyName);
	}

	@Override
	public String logicalColumnName(String columnName, String propertyName) {

		return super.logicalColumnName(columnName, propertyName);
	}

	@Override
	public String propertyToColumnName(String propertyName) {

		return super.propertyToColumnName(propertyName) + "_";
	}

	@Override
	public String tableName(String tableName) {

		return super.tableName(tableName) + "_";
	}
}
