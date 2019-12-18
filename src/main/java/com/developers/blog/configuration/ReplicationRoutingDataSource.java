package com.developers.blog.configuration;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static com.developers.blog.configuration.DatasourceType.MASTER;
import static com.developers.blog.configuration.DatasourceType.SLAVE;

public class ReplicationRoutingDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		return TransactionSynchronizationManager.isCurrentTransactionReadOnly() ? SLAVE : MASTER;
	}
}
