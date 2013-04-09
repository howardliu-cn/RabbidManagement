package rabbitmq.mgmt.model;

import java.util.Arrays;
import java.util.Collection;

public class Node {

	protected String name;
	protected String type;
	protected boolean running;
	protected Object[] partitions;
	protected String os_pid;
	protected int fd_used;
	protected int fd_total;
	protected int sockets_used;
	protected int sockets_total;
	protected long mem_used;
	protected long mem_limit;
	protected boolean mem_alarm;
	protected long disk_free_limit;
	protected long disk_free;
	protected boolean disk_free_alarm;
	protected long proc_used;
	protected long proc_total;
	protected String statistics_level;
	protected long uptime;
	protected long run_queue;
	protected int processors;
	protected Collection<ExchangeType> exchange_types;
	protected Collection<Capability> applications;
	protected Collection<AuthMechanism> auth_mechanisms;
	protected Collection<WebContext> contexts;
	
	public Node(){}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public boolean isRunning() {
		return running;
	}

	public Object[] getPartitions() {
		return partitions;
	}

	public String getOs_pid() {
		return os_pid;
	}

	public int getFd_used() {
		return fd_used;
	}

	public int getFd_total() {
		return fd_total;
	}

	public int getSockets_used() {
		return sockets_used;
	}

	public int getSockets_total() {
		return sockets_total;
	}

	public long getMem_used() {
		return mem_used;
	}

	public long getMem_limit() {
		return mem_limit;
	}

	public boolean isMem_alarm() {
		return mem_alarm;
	}

	public long getDisk_free_limit() {
		return disk_free_limit;
	}

	public long getDisk_free() {
		return disk_free;
	}

	public boolean isDisk_free_alarm() {
		return disk_free_alarm;
	}

	public long getProc_used() {
		return proc_used;
	}

	public long getProc_total() {
		return proc_total;
	}

	public String getStatistics_level() {
		return statistics_level;
	}

	public long getUptime() {
		return uptime;
	}

	public long getRun_queue() {
		return run_queue;
	}

	public int getProcessors() {
		return processors;
	}

	public Collection<ExchangeType> getExchange_types() {
		return exchange_types;
	}

	public Collection<Capability> getApplications() {
		return applications;
	}

	public Collection<AuthMechanism> getAuth_mechanisms() {
		return auth_mechanisms;
	}

	public Collection<WebContext> getContexts() {
		return contexts;
	}

	@Override
	public String toString() {
		return "Node [name=" + name + ", type=" + type + ", running=" + running
				+ ", partitions=" + Arrays.toString(partitions) + ", os_pid="
				+ os_pid + ", fd_used=" + fd_used + ", fd_total=" + fd_total
				+ ", sockets_used=" + sockets_used + ", sockets_total="
				+ sockets_total + ", mem_used=" + mem_used + ", mem_limit="
				+ mem_limit + ", mem_alarm=" + mem_alarm + ", disk_free_limit="
				+ disk_free_limit + ", disk_free=" + disk_free
				+ ", disk_free_alarm=" + disk_free_alarm + ", proc_used="
				+ proc_used + ", proc_total=" + proc_total
				+ ", statistics_level=" + statistics_level + ", uptime="
				+ uptime + ", run_queue=" + run_queue + ", processors="
				+ processors + ", exchange_types=" + exchange_types
				+ ", applications=" + applications + ", auth_mechanisms="
				+ auth_mechanisms + ", contexts=" + contexts + "]";
	}
}
