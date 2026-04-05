import './Settings.css'

const settings = [
  { label: 'Fusion host', value: 'ehxk-test' },
  { label: 'Fusion server', value: 'em2' },
  { label: 'VendHQ domain', value: 'ibraheemalqurashi' },
  { label: 'DB', value: 'Postgres (local)' },
  { label: 'Scheduler', value: 'APScheduler (in-process)' },
]

export const Settings = () => {
  return (
    <div className="settings">
      <div className="header-row">
        <div>
          <p className="eyebrow">Configuration</p>
          <h1>Environment settings</h1>
        </div>
      </div>
      <div className="settings-grid">
        {settings.map((s) => (
          <div className="setting" key={s.label}>
            <div className="metric-label">{s.label}</div>
            <div className="metric-value">{s.value}</div>
          </div>
        ))}
      </div>
    </div>
  )
}
