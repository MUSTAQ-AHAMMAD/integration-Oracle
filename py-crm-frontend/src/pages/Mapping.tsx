import './Mapping.css'

const receiptMethods = [
  { name: 'Cash', bank: 'Cash Account', activity: 'Cash Rounding' },
  { name: 'Credit Card', bank: 'Bank-CC-001', activity: 'Bank Charge' },
  { name: 'Apple Pay', bank: 'Bank-DIG-002', activity: 'Bank Charge' },
]

const taxCodes = [
  { name: 'STANDARD', fusion: 'OUTPUT-GOODS-DOM-5%', rate: '5%' },
  { name: 'ZERO', fusion: 'OUTPUT-ZERO', rate: '0%' },
  { name: 'EXEMPT', fusion: 'OUTPUT-EXEMPT', rate: '0%' },
]

const uoms = [
  { vend: 'Unit', fusion: 'Each' },
  { vend: 'Box', fusion: 'Box' },
  { vend: 'Kg', fusion: 'Kg' },
]

export const Mapping = () => {
  return (
    <div className="mapping">
      <div className="header-row">
        <div>
          <p className="eyebrow">Data mapping</p>
          <h1>Reference & receipt configuration</h1>
        </div>
        <div className="actions">
          <button className="ghost">Import CSV</button>
          <button className="primary">Save changes</button>
        </div>
      </div>

      <div className="mapping-grid">
        <div className="map-card">
          <div className="table-header">
            <h3>Receipt methods</h3>
            <span className="muted">Sample data</span>
          </div>
          <table>
            <thead>
              <tr>
                <th>Method</th>
                <th>Bank / Cash</th>
                <th>Receivable Activity</th>
              </tr>
            </thead>
            <tbody>
              {receiptMethods.map((r) => (
                <tr key={r.name}>
                  <td>{r.name}</td>
                  <td>{r.bank}</td>
                  <td>{r.activity}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>

        <div className="map-card">
          <div className="table-header">
            <h3>Tax codes</h3>
            <span className="pill ok">Aligned</span>
          </div>
          <table>
            <thead>
              <tr>
                <th>VendHQ</th>
                <th>Fusion</th>
                <th>Rate</th>
              </tr>
            </thead>
            <tbody>
              {taxCodes.map((t) => (
                <tr key={t.name}>
                  <td>{t.name}</td>
                  <td>{t.fusion}</td>
                  <td>{t.rate}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>

        <div className="map-card">
          <div className="table-header">
            <h3>UOM mapping</h3>
            <span className="muted">Per store overrides supported</span>
          </div>
          <table>
            <thead>
              <tr>
                <th>VendHQ</th>
                <th>Fusion</th>
              </tr>
            </thead>
            <tbody>
              {uoms.map((u) => (
                <tr key={u.vend}>
                  <td>{u.vend}</td>
                  <td>{u.fusion}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  )
}
