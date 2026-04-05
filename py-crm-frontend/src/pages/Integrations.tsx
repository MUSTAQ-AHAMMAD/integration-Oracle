import './Integrations.css'

const flows = [
  { name: 'VendHQ → Fusion Sales', status: 'Healthy', lastRun: '03:02', avgLatency: '6m 12s' },
  { name: 'Fusion → VendHQ Items', status: 'Healthy', lastRun: '18:00', avgLatency: '4m 05s' },
  { name: 'On-hand Sync', status: 'Paused', lastRun: '—', avgLatency: '—' },
]

const checks = [
  { label: 'Fusion SOAP', status: 'Up' },
  { label: 'Fusion REST', status: 'Up' },
  { label: 'VendHQ API', status: 'Up' },
  { label: 'DB', status: 'Up' },
]

export const Integrations = () => {
  return (
    <div className="integrations">
      <div className="header-row">
        <div>
          <p className="eyebrow">Pipelines</p>
          <h1>Integration Flows</h1>
        </div>
        <button className="primary">Trigger sync</button>
      </div>

      <div className="flow-grid">
        {flows.map((f) => (
          <div className="flow-card" key={f.name}>
            <div className="flow-head">
              <h3>{f.name}</h3>
              <span className={`pill ${f.status === 'Healthy' ? 'ok' : 'warn'}`}>{f.status}</span>
            </div>
            <div className="flow-meta">
              <div>
                <div className="metric-label">Last run</div>
                <div className="metric-value">{f.lastRun}</div>
              </div>
              <div>
                <div className="metric-label">Avg latency</div>
                <div className="metric-value">{f.avgLatency}</div>
              </div>
            </div>
            <div className="flow-actions">
              <button className="ghost">Run now</button>
              <button className="ghost">View logs</button>
            </div>
          </div>
        ))}
      </div>

      <div className="checks-card">
        <div className="table-header">
          <h3>Connectivity checks</h3>
          <span className="muted">Live ping</span>
        </div>
        <div className="checks">
          {checks.map((c) => (
            <div key={c.label} className="check">
              <span>{c.label}</span>
              <span className={`badge ${c.status === 'Up' ? 'success' : 'failed'}`}>{c.status}</span>
            </div>
          ))}
        </div>
      </div>
    </div>
  )
}
