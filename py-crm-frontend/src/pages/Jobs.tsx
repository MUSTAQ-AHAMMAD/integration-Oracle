import './Jobs.css'

const schedules = [
  { name: 'VendHQ → Fusion Sales', cron: '0 0 3 * * *', next: '03:00', prev: 'Yesterday 03:00', status: 'Running' },
  { name: 'Items Sync', cron: '0 0 */6 * * *', next: '00:00', prev: '18:00', status: 'Running' },
  { name: 'Backup', cron: '*/10 * * * *', next: '00:40', prev: '00:30', status: 'Running' },
  { name: 'On-hand Sync', cron: '0 0 */4 * * *', next: 'Paused', prev: 'Paused', status: 'Paused' },
]

const history = [
  { job: 'VendHQ → Fusion Sales', status: 'Success', duration: '6m 12s', at: 'Today 03:02' },
  { job: 'Backup', status: 'Success', duration: '18s', at: '00:30' },
  { job: 'Items Sync', status: 'Success', duration: '2m 48s', at: '00:05' },
  { job: 'VendHQ → Fusion Sales', status: 'Failed', duration: '—', at: 'Yesterday 03:01' },
]

export const Jobs = () => {
  return (
    <div className="jobs-page">
      <div className="header-row">
        <div>
          <p className="eyebrow">Scheduler</p>
          <h1>Jobs & Schedules</h1>
        </div>
        <div className="actions">
          <button className="ghost">Pause all</button>
          <button className="primary">Run sales job now</button>
        </div>
      </div>

      <div className="table-card">
        <div className="table-header">
          <h3>Active schedules</h3>
          <span className="pill ok">Auto</span>
        </div>
        <table>
          <thead>
            <tr>
              <th>Job</th>
              <th>Cron</th>
              <th>Next</th>
              <th>Previous</th>
              <th>Status</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {schedules.map((s) => (
              <tr key={s.name}>
                <td>{s.name}</td>
                <td className="mono">{s.cron}</td>
                <td>{s.next}</td>
                <td>{s.prev}</td>
                <td>
                  <span className={`badge ${s.status.toLowerCase()}`}>{s.status}</span>
                </td>
                <td className="actions-cell">
                  <button className="ghost">Run</button>
                  <button className="ghost">Pause</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      <div className="table-card">
        <div className="table-header">
          <h3>Recent history</h3>
          <span className="muted">Last 24h</span>
        </div>
        <table>
          <thead>
            <tr>
              <th>Job</th>
              <th>Status</th>
              <th>Duration</th>
              <th>Time</th>
            </tr>
          </thead>
          <tbody>
            {history.map((h, i) => (
              <tr key={i}>
                <td>{h.job}</td>
                <td>
                  <span className={`badge ${h.status.toLowerCase()}`}>{h.status}</span>
                </td>
                <td>{h.duration}</td>
                <td>{h.at}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  )
}
