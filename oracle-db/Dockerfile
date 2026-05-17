# Oracle Database 21c Express Edition Dockerfile
FROM container-registry.oracle.com/database/express:21.3.0-xe

# Set environment variables
ENV ORACLE_SID=XE \
    ORACLE_PDB=XEPDB1 \
    ORACLE_PWD=Oracle123 \
    ORACLE_CHARACTERSET=AL32UTF8

# Copy initialization scripts
COPY ./init-scripts/ /opt/oracle/scripts/setup/

# Expose Oracle listener port
EXPOSE 1521 5500

# Health check
HEALTHCHECK --interval=30s --timeout=10s --retries=5 \
  CMD echo "exit" | sqlplus -L sys/Oracle123@localhost:1521/XE as sysdba || exit 1
