import './Dashboard.css'

export const Dashboard = () => {
  const cards = [
    { label: 'Invoices Created', value: '128', tone: 'green' },
    { label: 'Receipts Posted', value: '117', tone: 'blue' },
    { label: 'Jobs Failed (24h)', value: '2', tone: 'red' },
    { label: 'Pending Sync', value: '14', tone: 'amber' },
  ]

  return (
    <div className="dash">
      <h1>Overview</h1>
      <div className="cards">
        {cards.map((card) => (
          <div className={`card ${card.tone}`} key={card.label}>
            <div className="value">{card.value}</div>
            <div className="label">{card.label}</div>
          </div>
        ))}
      </div>
      <div className="panels">
        <div className="panel">
          <header>
            <h3>Job Status</h3>
            <span className="pill ok">Healthy</span>
          </header>
          <ul>
            <li>
              VendHQ → Fusion Sales <span className="muted">Next: 03:00</span>
            </li>
            <li>
              Items Sync <span className="muted">Next: 00:00 / 6h</span>
            </li>
            <li>
              Backup <span className="muted">Every 10m</span>
            </li>
          </ul>
        </div>
        <div className="panel">
          <header>
            <h3>Alerts</h3>
            <span className="pill warn">2</span>
          </header>
          <ul>
            <li>2 receipts pending apply (SA region)</li>
            <li>Inventory journal latency 4m</li>
          </ul>
        </div>
      </div>
    </div>
  )
}
