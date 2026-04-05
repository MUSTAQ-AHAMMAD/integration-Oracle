import './Dashboard.css'

export const Dashboard = () => {
  const kpis = [
    { label: 'Invoices Created (24h)', value: '128', tone: 'green' },
    { label: 'Receipts Posted', value: '117', tone: 'blue' },
    { label: 'Jobs Failed', value: '2', tone: 'red' },
    { label: 'Pending Sync', value: '14', tone: 'amber' },
  ]

  const recentRuns = [
    { job: 'VendHQ → Fusion Sales', status: 'Success', duration: '6m 12s', time: 'Today 03:02' },
    { job: 'Items Sync', status: 'Success', duration: '2m 48s', time: 'Today 00:05' },
    { job: 'Backup', status: 'Success', duration: '18s', time: '00:10, 00:20, 00:30…' },
    { job: 'On-hand Sync', status: 'Warning', duration: '–', time: 'Paused' },
  ]

  const alerts = [
    '2 receipts pending apply (SA region)',
    'Inventory journal latency 4m',
    'Fusion tax code mismatch for 3 SKUs',
  ]

  const refData = [
    { label: 'Receipt Methods', value: '12' },
    { label: 'Tax Codes', value: '22' },
    { label: 'UOM Mappings', value: '48' },
    { label: 'Outlets', value: '31' },
  ]

  return (
    <div className="dash">
      <div className="header-row">
        <div>
          <p className="eyebrow">Fusion Integration Console</p>
          <h1>Operations Overview</h1>
        </div>
        <div className="env-badge">Environment: Local Demo</div>
      </div>

      <div className="cards">
        {kpis.map((card) => (
          <div className={`card ${card.tone}`} key={card.label}>
            <div className="value">{card.value}</div>
            <div className="label">{card.label}</div>
          </div>
        ))}
      </div>

      <div className="panels panels-2">
        <div className="panel">
          <header>
            <h3>Recent Runs</h3>
            <span className="pill ok">On track</span>
          </header>
          <table className="mini-table">
            <thead>
              <tr>
                <th>Job</th>
                <th>Status</th>
                <th>Duration</th>
                <th>Time</th>
              </tr>
            </thead>
            <tbody>
              {recentRuns.map((row) => (
                <tr key={row.job}>
                  <td>{row.job}</td>
                  <td>
                    <span className={`badge ${row.status.toLowerCase()}`}>{row.status}</span>
                  </td>
                  <td>{row.duration}</td>
                  <td>{row.time}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <div className="panel">
          <header>
            <h3>Alerts & Signals</h3>
            <span className="pill warn">{alerts.length}</span>
          </header>
          <ul className="list">
            {alerts.map((a) => (
              <li key={a}>{a}</li>
            ))}
          </ul>
          <div className="metrics">
            {refData.map((r) => (
              <div key={r.label}>
                <div className="metric-value">{r.value}</div>
                <div className="metric-label">{r.label}</div>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  )
}
